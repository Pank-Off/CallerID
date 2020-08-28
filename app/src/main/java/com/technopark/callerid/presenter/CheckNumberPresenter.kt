package com.technopark.callerid.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.checkNumber.CheckNumberView
import io.michaelrocks.libphonenumber.android.NumberParseException
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

class CheckNumberPresenter(private var checkNumberView: CheckNumberView) {
    private lateinit var util: PhoneNumberUtil
    private lateinit var correctPhone: String

    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model

    fun checkValidNumber(context: Context?, number: String) {

        util = PhoneNumberUtil.createInstance(context)
        try {
            val phoneNumber: Phonenumber.PhoneNumber = util.parse(number, "RU")
            correctPhone = util.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164)
            Log.d("CorrectPhone", correctPhone)

            if (util.isPossibleNumber(phoneNumber)) {
                checkNumberView.validNumber()
            } else {
                checkNumberView.invalidNumber()
            }
        } catch (exc: NumberParseException) {
            Log.e("NumberParseException", exc.errorType.name)
            checkNumberView.invalidNumber()
        }
    }

    fun getSingleUserInfo() {
        val isSpam: String = model.getSingleUserInfo(correctPhone)
        Log.d(Thread.currentThread().name, isSpam)
        model.getAllData()
        checkNumberView.isSpam(isSpam)
    }
}