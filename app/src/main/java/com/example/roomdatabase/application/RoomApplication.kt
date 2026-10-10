package com.example.roomdatabase.application

import android.app.Application
import androidx.room.Room
import com.example.roomdatabase.data.database.AppDatabase

class RoomApplication: Application() {
    companion object{
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-users"
        ).build()
    }

}