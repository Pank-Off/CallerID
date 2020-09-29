package com.technopark.callerid.view

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.provider.BlockedNumberContract.BlockedNumbers
import android.telecom.TelecomManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.technopark.callerid.R
import com.technopark.callerid.view.ui.settings.SettingsFragment


class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavBar()
        setThemeMode()
        if (Build.VERSION.SDK_INT >= 24) {
            //blockNumber()
        }
    }

    private fun setThemeMode() {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(packageName, Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean(SettingsFragment.KEY, false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                supportActionBar?.setBackgroundDrawable(
                    ColorDrawable(resources.getColor(R.color.textFieldColor, null))
                )
            }
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun initNavBar() {
        navView = findViewById(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_call_log,
            R.id.navigation_check_number, R.id.navigation_spam_protection, R.id.navigation_settings
        ).build()

        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    private fun blockNumber() {
        //val c: Context = this
        val t: TelecomManager? = getSystemService(Context.TELECOM_SERVICE) as TelecomManager?
        //c.startActivity(t.createManageBlockedNumbersIntent(), null);
        val values = ContentValues()
        values.put(BlockedNumbers.COLUMN_ORIGINAL_NUMBER, "+79152274034")
        val uri = contentResolver.insert(BlockedNumbers.CONTENT_URI, values)
    }
}
