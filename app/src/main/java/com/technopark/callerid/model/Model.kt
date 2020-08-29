package com.technopark.callerid.model

import android.content.Context
import com.technopark.callerid.R
import com.technopark.callerid.view.ui.callLog.PhoneBook
import me.everything.providers.android.calllog.Call
import me.everything.providers.android.calllog.CallsProvider
import java.lang.Exception

class Model {

    private val phoneBooks = arrayListOf<PhoneBook>()
    private val mDatabaseHelper: DatabaseHelper = DatabaseHelper()

    fun setPhoneBooks(context: Context?) {
        phoneBooks.clear()

        val temp = arrayListOf<PhoneBook>()
        val contacts = arrayListOf<String>()
        val names = arrayListOf<String>()
        val types = arrayListOf<Call.CallType>()

        val callsProvider = CallsProvider(context)
        val number: List<Call> = callsProvider.calls.list
        val numberSize: Int = number.size.coerceAtMost(10)
        for (i in 0 until numberSize) {
            contacts.add(number[i].number)
            names.add(number[i].name)
            types.add(number[i].type) //краш если звонок был принят/сделан с другой симки(types = null) // а еще сброшенный звонок тоже это null тип((
            var callTypeImage: Int?
            try {
                callTypeImage = determineType(types[i], contacts[i])
            }
            catch(e: Exception) {
                callTypeImage = 0
            }
            temp.add(
                PhoneBook(
                    if (callTypeImage != null) callTypeImage else 0,
                    if (names[i] == null) "Unknown Number" else names[i],
                    contacts[i]
                )
            )
        }
        phoneBooks.addAll(temp)
    }

    fun getPhoneBooks(): ArrayList<PhoneBook> = phoneBooks

    private fun determineType(type: Call.CallType, number: String): Int {
        val isSpam: String = mDatabaseHelper.getSingleUserInfo(number)
        if (isSpam == "Is spam") {
            return R.drawable.bancircle
        }
        if (type == Call.CallType.INCOMING) {
            return R.drawable.incomming
        } else if (type == Call.CallType.OUTGOING) {
            return R.drawable.outgoing
        }
        return R.drawable.missing
    }

    fun addRecord(number: String, isSpam: Boolean, comment: String) {
        mDatabaseHelper.addRecord(number, isSpam, comment)
    }

    fun removeRecord(number: String) {
        mDatabaseHelper.removeRecord(number)
    }

    fun getAllData() {
        mDatabaseHelper.getData()
    }

    fun getSingleUserInfo(number: String): String {
        return mDatabaseHelper.getSingleUserInfo(number)
    }
}