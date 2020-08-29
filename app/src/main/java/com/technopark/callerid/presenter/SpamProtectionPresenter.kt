package com.technopark.callerid.presenter

import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.model.room.Spamer
import com.technopark.callerid.view.ui.spamProtection.SpamProtectionView
import javax.inject.Inject

class SpamProtectionPresenter(spamProtectionView: SpamProtectionView) {
    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model

    fun getDataFromDB():List<Spamer>{
     return model.getAllData()
    }
}