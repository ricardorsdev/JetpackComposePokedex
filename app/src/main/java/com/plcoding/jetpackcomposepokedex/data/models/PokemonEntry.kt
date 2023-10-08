package com.plcoding.jetpackcomposepokedex.data.models

import com.plcoding.jetpackcomposepokedex.data.remote.response.Sprites
import com.plcoding.jetpackcomposepokedex.data.remote.response.Stat
import com.plcoding.jetpackcomposepokedex.data.remote.response.Type

data class PokemonEntry(
    val id: Int,
    val name: String,
    val types: List<Type>,
    val weight: Int,
    val height: Int,
    val stats: List<Stat>,
    val sprites: Sprites
)
