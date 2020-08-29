package com.technopark.callerid.presenter

import android.util.Log
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.checkNumber.CheckNumberView
import javax.inject.Inject

class CheckNumberPresenter(private var checkNumberView: CheckNumberView) {
    private lateinit var util: PhoneNumberUtil
    private lateinit var correctPhone: String

    init {
        App.getAppComponent().inject(this)
    }

    @Inject
    lateinit var model: Model

    fun checkValidNumber(number: String) {

        util = PhoneNumberUtil.getInstance()
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