package com.light.roomdbretrofit.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.light.roomdbretrofit.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase(){

    abstract fun getFakerDao() : FakerDAO
}