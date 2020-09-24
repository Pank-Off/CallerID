package com.technopark.callerid.presenter

import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.spamProtection.EditNumberView
import javax.inject.Inject

class EditNumberPresenter(private var editNumberView: EditNumberView) {
    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model

    fun removeRecord(number: String) {
        model.removeRecord(number)
        editNumberView.removeSuccessful()
    }
}