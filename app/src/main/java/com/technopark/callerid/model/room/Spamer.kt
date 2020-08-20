package com.technopark.callerid.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_spamers")
class Spamer {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    lateinit var isSpam: String

    lateinit var phoneNumber: String

    lateinit var comment: String


    constructor(comment: String) {
        this.comment = comment
    }

}