package com.plcoding.jetpackcomposepokedex.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.jetpackcomposepokedex.data.models.PokemonEntry
import com.plcoding.jetpackcomposepokedex.data.remote.response.Sprites
import com.plcoding.jetpackcomposepokedex.data.remote.response.Stat
import com.plcoding.jetpackcomposepokedex.data.remote.response.Type

@Entity
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val types: List<Type>,
    val weight: Int,
    val height: Int,
    val stats: List<Stat>,
    val sprites: Sprites
) {
    fun toPokemonEntity(): PokemonEntry {
        return PokemonEntry(
            id = id,
            name = name,
            stats = stats,
            weight = weight,
            height = height,
            types = types,
            sprites = sprites
        )
    }
}

