package com.plcoding.jetpackcomposepokedex.data.remote.response

import com.google.gson.annotations.SerializedName
import com.plcoding.jetpackcomposepokedex.data.local.entity.PokemonEntity

data class Pokemon(
    val abilities: List<Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    val forms: List<Form>,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {
    fun toPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            id = id,
            height = height,
            name = name,
            stats = stats,
            types = types,
            weight = weight,
            sprites = sprites
        )
    }
}