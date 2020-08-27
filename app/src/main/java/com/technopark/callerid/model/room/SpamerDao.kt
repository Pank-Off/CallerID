package com.technopark.callerid.model.room

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface SpamerDao {

    @Insert
    fun insert(spamer: Spamer): Single<Long>

    @Query("DELETE FROM table_spamers WHERE phoneNumber = :phoneNumber")
    fun delete(phoneNumber: String): Single<Int>

    @Query("SELECT * FROM table_spamers")
    fun getAll(): Single<List<Spamer>>

    @Query("SELECT * FROM table_spamers WHERE phoneNumber = :phoneNumber")
    fun getSingleUserInfo(phoneNumber: String): Cursor
}