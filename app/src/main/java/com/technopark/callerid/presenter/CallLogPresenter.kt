package com.technopark.callerid.presenter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.callLog.CallLogView
import javax.inject.Inject

class CallLogPresenter(var callLogView: CallLogView) {
    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model

    fun getContactNames(context: Context?) {
        Log.d("Coroutine", Thread.currentThread().name)
        model.setPhoneBooks(context)
        callLogView.setCallLog(model.getPhoneBooks())
    }

    fun setOnClickAllowBtnListener(context: Context?): Intent {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri =
            Uri.fromParts("package", context?.packageName, null)
        intent.data = uri
        return intent
    }
}