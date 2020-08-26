package com.technopark.callerid.model

import android.content.Context
import com.technopark.callerid.R
import com.technopark.callerid.view.ui.callLog.PhoneBook
import me.everything.providers.android.calllog.Call
import me.everything.providers.android.calllog.CallsProvider
import java.util.function.UnaryOperator

class Model {

    private val phoneBooks: ArrayList<PhoneBook> = ArrayList()
    private val mDatabaseHelper: DatabaseHelper = DatabaseHelper()

    fun setPhoneBooks(context: Context?) {
        phoneBooks.clear()
        val temp: ArrayList<PhoneBook> = ArrayList()
        val contacts: ArrayList<String> = ArrayList()
        val names: ArrayList<String> = ArrayList()
        val types: ArrayList<Call.CallType> = ArrayList()

        val callsProvider = CallsProvider(context)
        val number: List<Call> = callsProvider.calls.list
        val numberSize: Int = number.size.coerceAtMost(10)
        for (i in 0 until numberSize) {
            contacts.add(number[i].number)
            names.add(number[i].name)
            types.add(number[i].type) //краш если звонок был принят/сделан с другой симки(types = null) // а еще сброшенный звонок тоже это null тип((
            temp.add(
                PhoneBook(
                    determineType(types[i], contacts[i]),
                    if (names[i] == null) "Unknown Number" else names[i],
                    contacts[i]
                )
            )
        }
        phoneBooks.addAll(temp)
    }

    fun getPhoneBooks(): ArrayList<PhoneBook> = phoneBooks

    private fun determineType(type: Call.CallType, number: String): Int {
//        val isSpam: String = mDatabaseHelper.getSingleUserInfo(number)
//        if (isSpam == "Is spam") {
//            return R.drawable.bancircle
//        }
        if (type == Call.CallType.INCOMING) {
            return R.drawable.incomming
        } else if (type == Call.CallType.OUTGOING) {
            return R.drawable.outgoing
        }
        return R.drawable.missing
    }
}