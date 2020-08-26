package com.technopark.callerid.model

import android.database.Cursor
import com.technopark.callerid.app.App
import com.technopark.callerid.model.room.SpamerDao

class DatabaseHelper {

    private val COL1 = "ID"
    private val COL2 = "phoneNumber"
    private val COL3 = "isSpam"
    private val COL4 = "comment"

    private var spamerDao: SpamerDao = App.getAppDatabase().spamerDao()

    fun getSingleUserInfo(number: String): String {
        val cursor: Cursor = spamerDao.getSingleUserInfo(number)
        var result = ""
        if (cursor.moveToFirst()) {
            val intIsSpam =
                cursor.getInt(cursor.getColumnIndex(COL3))
            cursor.close()
            if (intIsSpam == 1) {
                result = "Is spam"
            }
            if (intIsSpam == 0) {
                result = "Not spam"
            }
        } else {
            result = "Not found"
        }
        return result
    }
}