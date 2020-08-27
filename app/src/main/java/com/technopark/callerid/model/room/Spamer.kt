package com.technopark.callerid.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_spamers")
class Spamer(var phoneNumber: String, var isSpam: Boolean, var comment: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "Spamer{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isSpam='" + isSpam + '\'' +
                ", comment='" + comment + '\'' +
                '}'
    }

}