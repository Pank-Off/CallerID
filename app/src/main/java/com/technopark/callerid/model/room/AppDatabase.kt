package com.technopark.callerid.model.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Spamer::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun spamerDao(): SpamerDao
}