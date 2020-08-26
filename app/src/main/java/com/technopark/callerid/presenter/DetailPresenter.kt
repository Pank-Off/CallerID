package com.technopark.callerid.presenter

import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.callLog.DetailView
import javax.inject.Inject

class DetailPresenter(var detailView: DetailView) {

    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model

    fun addRecord(number: String, isSpam: Boolean, comment: String) {
        model.addRecord(number, isSpam, comment)
        detailView.addSuccessful()
    }

    fun removeRecord(number: String) {
        model.removeRecord(number)
        detailView.removeSuccessful()
    }
}