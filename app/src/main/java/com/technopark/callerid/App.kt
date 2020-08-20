package com.technopark.callerid

import android.app.Application
import android.content.SharedPreferences
import com.technopark.callerid.model.DatabaseHelper
import com.technopark.callerid.model.FireBaseWorker
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class App : Application() {

    private lateinit var fireBaseWorker: FireBaseWorker
    private lateinit var db: DatabaseHelper

    companion object {
        private lateinit var instance: App
        val APP_PREFERENCES = "callerIDPreferences"
        //@JvmStatic
        public fun getInstance(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        db = DatabaseHelper(this)

        val df: DateFormat = SimpleDateFormat("dd/MM/yy", Locale.US)
        val currentDate = df.format(Date())
        val dateTimeKey = "lastUpdateDate"

        val sharedPreferences: SharedPreferences = getSharedPreferences(APP_PREFERENCES, 0)

        if (sharedPreferences.getBoolean("firstRun", true)) {
            sharedPreferences.edit().putBoolean("firstRun", false).apply()
            fireBaseWorker = FireBaseWorker(applicationContext)
            fireBaseWorker.download()

            sharedPreferences.edit().putString(dateTimeKey, currentDate).apply()
            sharedPreferences.edit().apply()
        } else {
            val lastUpdateDate = sharedPreferences.getString(dateTimeKey, currentDate)
            if (currentDate != lastUpdateDate) {
                fireBaseWorker = FireBaseWorker(applicationContext)
                fireBaseWorker.download()
                sharedPreferences.edit().putString(dateTimeKey, currentDate).apply()
                sharedPreferences.edit().apply()
            }
        }
    }

    public fun getDataBase(): DatabaseHelper = db

}