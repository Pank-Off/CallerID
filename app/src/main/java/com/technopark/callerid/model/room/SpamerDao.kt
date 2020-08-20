package com.technopark.callerid.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface SpamerDao {

    @Insert
    fun insert(spamer: Spamer): Single<Long>

    @Query("SELECT * FROM table_spamers")
    fun getAll(): Single<List<Spamer>>
}