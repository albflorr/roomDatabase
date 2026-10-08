package com.example.roomdatabase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.dao.UserDao
import com.example.roomdatabase.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
