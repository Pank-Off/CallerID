package com.technopark.callerid.app

import android.app.Application
import android.content.SharedPreferences
import androidx.room.Room
import com.technopark.callerid.model.FirebaseWorker
import com.technopark.callerid.model.room.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class App : Application() {

    private lateinit var firebaseWorker: FirebaseWorker
    // private lateinit var db: DatabaseHelper

    companion object {
        private lateinit var instance: App
        private lateinit var appDatabase: AppDatabase
        private lateinit var appComponent: AppComponent
        val APP_PREFERENCES = "callerIDPreferences"

        //@JvmStatic
        fun getInstance(): App = instance

        fun getAppDatabase(): AppDatabase = appDatabase

        fun getAppComponent(): AppComponent = appComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //db = DatabaseHelper(this)
        appDatabase = generateAppDataBase()
        appComponent = generateAppComponent()
        tryDownloadDBFromfirebase();

    }

    private fun generateAppComponent(): AppComponent {
        return DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    private fun generateAppDataBase(): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "room_database"
        )
            // .allowMainThreadQueries()  //только для тестирования
            .build()
    }

    private fun tryDownloadDBFromfirebase() {
        val df: DateFormat = SimpleDateFormat("dd/MM/yy", Locale.US)
        val currentDate = df.format(Date())
        val dateTimeKey = "lastUpdateDate"

        val sharedPreferences: SharedPreferences = getSharedPreferences(APP_PREFERENCES, 0)

        if (sharedPreferences.getBoolean("firstRun", true)) {
            sharedPreferences.edit().putBoolean("firstRun", false).apply()
            firebaseWorker = FirebaseWorker(applicationContext)
            firebaseWorker.download()
            sharedPreferences.edit().putString(dateTimeKey, currentDate).apply()
            sharedPreferences.edit().apply()
        } else {
            val lastUpdateDate = sharedPreferences.getString(dateTimeKey, currentDate)
            if (currentDate != lastUpdateDate) {
                firebaseWorker = FirebaseWorker(applicationContext)
                firebaseWorker.download()
                sharedPreferences.edit().putString(dateTimeKey, currentDate).apply()
                sharedPreferences.edit().apply()
            }
        }
    }
    //public fun getDataBase(): DatabaseHelper = db
}