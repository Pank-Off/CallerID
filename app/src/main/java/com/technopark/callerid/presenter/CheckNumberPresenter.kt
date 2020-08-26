package com.technopark.callerid.presenter

import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.checkNumber.CheckNumberView
import javax.inject.Inject

class CheckNumberPresenter(private var checkNumberView: CheckNumberView) {
    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model
    fun getTest(){
        model.getAllData()
    }
}