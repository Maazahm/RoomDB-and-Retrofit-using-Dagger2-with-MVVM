package com.light.roomdbretrofit.di

import android.content.Context
import androidx.room.Room
import com.light.roomdbretrofit.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    // It is a provides method so we annotate with Provides annotation and one instance of room database
    // is required throughout the application so we use singleton as annotation.
    // When dagger reaches this function it will check whether it has context value then it will confirm
    // that yes the value is passed and bind in factory in ApplicationComponent. So, dagger will use
    // the context from the component whenever it is required.
    // Then the Database object can be created.
    @Singleton
    @Provides
    fun provideFakerDB(context : Context) : FakerDB{
        // In dagger whenever we require runtime values we use factory to provide objects,
        // context is a runtime value and to initialize it we use factory.
        // We define our factory in ApplicationComponent interface.
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB")
            .build()
    }
}