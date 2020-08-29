package com.technopark.callerid.model

import android.content.Context
import com.technopark.callerid.R
import com.technopark.callerid.view.ui.callLog.PhoneBook
import me.everything.providers.android.calllog.Call
import me.everything.providers.android.calllog.CallsProvider

class Model {

    private val phoneBooks = arrayListOf<PhoneBook>()
    private val mDatabaseHelper: DatabaseHelper = DatabaseHelper()

    fun setPhoneBooks(context: Context?) {
        phoneBooks.clear()

        val contacts = arrayListOf<String>()
        val names = arrayListOf<String>()
        val types = arrayListOf<Call.CallType>()

        val callsProvider = CallsProvider(context)
        val number: List<Call> = callsProvider.calls.list
        val numberSize: Int = number.size.coerceAtMost(25)
        for (i in 0 until numberSize) {
            contacts.add(number[i].number)
            names.add(number[i].name)
            types.add(number[i].type)
            val callTypeImage: Int = try {
                determineType(types[i], contacts[i])
            } catch(e: Exception) {
                0
            }
           phoneBooks.add(
                PhoneBook(
                    callTypeImage,
                    if (names[i] == null) "Unknown Number" else names[i],
                    contacts[i]
                )
            )
        }
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