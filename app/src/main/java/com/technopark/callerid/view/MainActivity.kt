package com.technopark.callerid.view

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.technopark.callerid.R
import com.technopark.callerid.presenter.MainPresenter
import com.technopark.callerid.view.ui.settings.SettingsFragment


class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavBar()

        setThemeMode()
        //val mainPresenter: MainPresenter = MainPresenter()

        //  mainPresenter.putDataInDB()
        //   Thread.sleep(1000)
        //   mainPresenter.getDataFromDB()
    }

    private fun setThemeMode() {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(packageName, Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean(SettingsFragment.KEY, false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.textFieldColor)))
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
}