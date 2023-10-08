package com.plcoding.jetpackcomposepokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plcoding.jetpackcomposepokedex.data.local.entity.PokedexListEntryEntity
import com.plcoding.jetpackcomposepokedex.data.local.entity.PokemonEntity

@Database(
    entities = [PokedexListEntryEntity::class, PokemonEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PokedexDatabase : RoomDatabase() {
    abstract val dao: PokedexDao
}