package com.plcoding.jetpackcomposepokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.jetpackcomposepokedex.data.local.entity.PokedexListEntryEntity
import com.plcoding.jetpackcomposepokedex.data.local.entity.PokemonEntity

@Dao
interface PokedexDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokedexListEntries(pokedexListEntries: List<PokedexListEntryEntity>)

    @Query("SELECT * FROM pokedexlistentryentity")
    suspend fun getPokedexListEntries(): List<PokedexListEntryEntity>

    @Query("DELETE FROM pokedexlistentryentity WHERE number IN (:numbers)")
    suspend fun deletePokedexListEntries(numbers: List<Int>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonInfo(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemonentity WHERE name = :name")
    suspend fun getPokemonInfo(name: String): PokemonEntity?

    @Query("DELETE FROM pokemonentity WHERE name = :name")
    suspend fun deletePokemonInfo(name: String)

}