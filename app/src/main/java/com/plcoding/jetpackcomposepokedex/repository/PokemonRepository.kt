package com.plcoding.jetpackcomposepokedex.repository

import com.plcoding.jetpackcomposepokedex.data.local.PokedexDao
import com.plcoding.jetpackcomposepokedex.data.models.PokedexPage
import com.plcoding.jetpackcomposepokedex.data.models.PokemonEntry
import com.plcoding.jetpackcomposepokedex.data.remote.PokeApi
import com.plcoding.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi,
    private val pokedexDao: PokedexDao
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokedexPage> {
        try {
            val response = api.getPokemonList(limit, offset)
            val numberList = response.results.map { it.getPokemonNumberFromUrl() }
            pokedexDao.deletePokedexListEntries(numberList)
            pokedexDao.insertPokedexListEntries(response.results.map { it.toPokedexListEntryEntity() })

            val data = pokedexDao.getPokedexListEntries().map { it.toPokedexListEntry() }
            return Resource.Success(PokedexPage(count = response.count, results = data))
        } catch (e: Exception) {
            val data = pokedexDao.getPokedexListEntries().map { it.toPokedexListEntry() }

            return if (data.isNotEmpty()) {
                Resource.Success(PokedexPage(count = 0, results = data))
            } else {
                Resource.Error(e.localizedMessage ?: "An Unknown Error occurred")
            }
        }
    }

    suspend fun getPokemonInfo(name: String): Resource<PokemonEntry> {
        try {
            val response = api.getPokemonInfo(name)
            pokedexDao.deletePokemonInfo(name)
            pokedexDao.insertPokemonInfo(response.toPokemonEntity())

            pokedexDao.getPokemonInfo(name)?.let {
                return Resource.Success(it.toPokemonEntity())
            } ?: run {
                return Resource.Error("No data was found.")
            }
        } catch (e: Exception) {
            pokedexDao.getPokemonInfo(name)?.let {
                return Resource.Success(it.toPokemonEntity())
            } ?: run {
                return Resource.Error(e.localizedMessage ?: "An Unknown Error occurred")
            }
        }
    }
}