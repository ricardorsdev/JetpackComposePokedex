package com.plcoding.jetpackcomposepokedex.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.plcoding.jetpackcomposepokedex.data.remote.response.Sprites
import com.plcoding.jetpackcomposepokedex.data.remote.response.Stat
import com.plcoding.jetpackcomposepokedex.data.remote.response.Type


@ProvidedTypeConverter
class Converters(private val gson: Gson) {
    @TypeConverter
    fun fromStatsJson(json: String): List<Stat> {
        val listType: java.lang.reflect.Type = object : TypeToken<List<Stat>>() {}.type
        return gson.fromJson(json, listType)
    }

    @TypeConverter
    fun toStatsJson(stats: List<Stat>): String {
        return gson.toJson(stats)
    }

    @TypeConverter
    fun fromTypesJson(json: String): List<Type> {
        val listType: java.lang.reflect.Type = object : TypeToken<List<Type>>() {}.type
        return gson.fromJson(json, listType)
    }

    @TypeConverter
    fun toTypesJson(types: List<Type>): String {
        return gson.toJson(types)
    }

    @TypeConverter
    fun fromSpritesJson(json: String): Sprites {
        val type: java.lang.reflect.Type = object : TypeToken<Sprites>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun toSpritesJson(sprites: Sprites): String {
        return gson.toJson(sprites)
    }

}