package com.technopark.callerid.model

import android.content.Context
import com.technopark.callerid.R
import com.technopark.callerid.model.room.Spamer
import com.technopark.callerid.view.ui.callLog.PhoneBook
import me.everything.providers.android.calllog.Call
import me.everything.providers.android.calllog.CallsProvider
import java.text.SimpleDateFormat
import java.util.*


class Model {

    private val phoneBooks = arrayListOf<PhoneBook>()
    private val mDatabaseHelper: DatabaseHelper = DatabaseHelper()

    fun setPhoneBooks(context: Context?) {
        phoneBooks.clear()

        val callsProvider = CallsProvider(context)
        val number: List<Call> = callsProvider.calls.list

        val numberSize: Int = number.size.coerceAtMost(25)
        for (i in 0 until numberSize) {
            val timeList = parseDate(number[i])


            val callTypeImage: Int = try {
                determineType(number[i].type, number[i].number)
            } catch (e: Exception) {
                0
            }
            phoneBooks.add(
                PhoneBook(
                    callTypeImage,
                    number[i].name ?: "Unknown Number",
                    number[i].number, timeList
                )
            )
        }
    }

    private fun parseDate(number: Call): List<String> {
        val seconds = number.callDate
        val date = Date(seconds)
        val simpleDateFormat = SimpleDateFormat("EEEE MMMM d yyyy H:mm", Locale.ENGLISH)

        simpleDateFormat.timeZone = TimeZone.getTimeZone("Europe/Moscow")
        val dateString = simpleDateFormat.format(date)
        return dateString.split(" ")
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

    fun addRecord(number: String, isSpam: Boolean, comment: String): Boolean {
        return mDatabaseHelper.addRecord(number, isSpam, comment)
    }

    fun removeRecord(number: String) {
        mDatabaseHelper.removeRecord(number)
    }

    fun replaceRecord(oldNumber: String, correctPhone: String, newComment: String) {
        mDatabaseHelper.replaceRecord(oldNumber, correctPhone, newComment)
    }

    fun getAllData(): List<Spamer> {
        return mDatabaseHelper.getData()
    }

    fun getSingleUserInfo(number: String): String {
        return mDatabaseHelper.getSingleUserInfo(number)
    }
}