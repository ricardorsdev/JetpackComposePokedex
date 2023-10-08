package com.plcoding.jetpackcomposepokedex.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.plcoding.jetpackcomposepokedex.data.local.Converters
import com.plcoding.jetpackcomposepokedex.data.local.PokedexDatabase
import com.plcoding.jetpackcomposepokedex.data.remote.PokeApi
import com.plcoding.jetpackcomposepokedex.repository.PokemonRepository
import com.plcoding.jetpackcomposepokedex.util.Constants.BASE_URL
import com.plcoding.jetpackcomposepokedex.util.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesPokemonRepository(api: PokeApi, db: PokedexDatabase): PokemonRepository {
        return PokemonRepository(api, db.dao)
    }

    @Provides
    @Singleton
    fun providesPokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(PokeApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokedexDatabase(app: Application): PokedexDatabase {
        return Room.databaseBuilder(app, PokedexDatabase::class.java, DB_NAME)
            .addTypeConverter(Converters(Gson()))
            .build()
    }
}