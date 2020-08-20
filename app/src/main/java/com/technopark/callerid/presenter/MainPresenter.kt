package com.technopark.callerid.presenter

import android.util.Log
import com.technopark.callerid.app.App
import com.technopark.callerid.model.room.Spamer
import com.technopark.callerid.model.room.SpamerDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenter {
    var spamerDao: SpamerDao = App.getAppDatabase().spamerDao()

    fun putDataInDB() {
        val spamerList: List<Spamer> =
            listOf(Spamer("A"), Spamer("B"), Spamer("C"), Spamer("D"), Spamer("F"))

        for (spamer in spamerList) {
            val disposable: Disposable =
                spamerDao.insert(spamer).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { id ->
                            Log.d(Thread.currentThread().name, id.toString())
                        },
                        { throwable ->
                            Log.d(Thread.currentThread().name, throwable.toString())
                        })
        }
    }

    fun getDataFromDB() {
        val disposable: Disposable =
            spamerDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { spamers ->
                        run {
                            for (spam in spamers) {
                                Log.d("Spamer" + spam.id, spam.comment)
                            }
                        }
                    },
                    { throwable ->
                        Log.d(Thread.currentThread().name, throwable.toString())
                    })
    }
}