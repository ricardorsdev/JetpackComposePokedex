package com.plcoding.jetpackcomposepokedex.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.jetpackcomposepokedex.data.models.PokedexListEntry

@Entity
data class PokedexListEntryEntity(
    @PrimaryKey val number: Int,
    val pokemonName: String,
    val imageUrl: String
) {
    fun toPokedexListEntry(): PokedexListEntry {
        return PokedexListEntry(
            pokemonName = pokemonName.capitalize(),
            imageUrl = imageUrl,
            number = number
        )
    }
}
