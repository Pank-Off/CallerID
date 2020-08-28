package com.technopark.callerid.model.room

import android.database.Cursor
import androidx.room.*
import io.reactivex.Single

@Dao
interface SpamerDao {

    @Insert //(onConflict = OnConflictStrategy.REPLACE)
    fun insert(spamer: Spamer): Single<Long>

    @Query("DELETE FROM table_spamers WHERE phoneNumber = :phoneNumber")
    fun delete(phoneNumber: String): Single<Int>

    @Query("SELECT * FROM table_spamers")
    fun getAll(): Single<List<Spamer>>

    @Query("SELECT * FROM table_spamers WHERE phoneNumber = :phoneNumber")
    fun getSingleUserInfo(phoneNumber: String): Cursor
}