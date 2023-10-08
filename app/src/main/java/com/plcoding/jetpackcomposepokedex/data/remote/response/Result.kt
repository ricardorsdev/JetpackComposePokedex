package com.plcoding.jetpackcomposepokedex.data.remote.response

import com.plcoding.jetpackcomposepokedex.data.local.entity.PokedexListEntryEntity

data class Result(
    val name: String,
    val url: String
) {
    fun toPokedexListEntryEntity(): PokedexListEntryEntity {
        val number = getPokemonNumberFromUrl()
        return PokedexListEntryEntity(
            number = number,
            pokemonName = name,
            imageUrl = generatePokemonImageUrl()
        )
    }

    fun getPokemonNumberFromUrl(): Int {
        return if (url.endsWith("/")) {
            url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            url.takeLastWhile { it.isDigit() }
        }.toInt()
    }

    private fun generatePokemonImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getPokemonNumberFromUrl()}.png"
    }
}