package com.technopark.callerid.presenter

import android.util.Log
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.technopark.callerid.app.App
import com.technopark.callerid.model.Model
import com.technopark.callerid.view.ui.spamProtection.AddNumberView
import javax.inject.Inject

class AddNumberPresenter(private var addNumberView: AddNumberView) {

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
                addNumberView.validNumber()
            } else {
                addNumberView.invalidNumber()
            }
        } catch (exc: NumberParseException) {
            Log.e("NumberParseException", exc.errorType.name)
            addNumberView.invalidNumber()
        }
    }

    fun addRecord(number: String, isSpam: Boolean, comment: String) {
        val duplicateIsFound: Boolean = model.addRecord(number, isSpam, comment)
        if (duplicateIsFound) {
            addNumberView.addFailed()
        } else {
            addNumberView.addSuccessful()
        }
    }

    fun replaceRecord(correctPhone: String, newComment: String) {
        model.replaceRecord(correctPhone, newComment)
        addNumberView.replaceSuccessful()
    }
}