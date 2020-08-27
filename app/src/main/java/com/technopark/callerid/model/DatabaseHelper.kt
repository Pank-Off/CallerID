package com.technopark.callerid.model

import android.database.Cursor
import android.util.Log
import com.technopark.callerid.app.App
import com.technopark.callerid.model.room.Spamer
import com.technopark.callerid.model.room.SpamerDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DatabaseHelper() {

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
            Log.d("ssss", intIsSpam.toString())
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

    fun addRecord(number: String, isSpam: Boolean, comment: String) {
        val spamer = Spamer(number, isSpam, comment)
        val disposable: Disposable =
            spamerDao.insert(spamer).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ id ->
                    Log.d(Thread.currentThread().name, id.toString())
                },
                    { throwable ->
                        Log.d(Thread.currentThread().name, throwable.toString())
                    })
    }

    fun getData() {
        val disposable: Disposable =
            spamerDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { users ->
                        Log.d(Thread.currentThread().name, "getData: $users")
                    },
                    { throwable ->
                        Log.d(Thread.currentThread().name, "getData: $throwable")
                    })
    }

    fun removeRecord(number: String) {
        val disposable: Disposable =
            spamerDao.delete(number).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { id ->
                        Log.d(Thread.currentThread().name, "deleteData: $id")
                    },
                    { throwable ->
                        Log.d(Thread.currentThread().name, "deleteData: $throwable")
                    })
    }
}

