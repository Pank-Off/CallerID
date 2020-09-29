package com.technopark.callerid.view.ui.callLog

class PhoneBook(
    private var icon: Int,
    private var name: String,
    private var number: String,
    private var timeList: List<String>
) {
    fun getName() = name
    fun getIcon() = icon
    fun getNumber(): String = number
    fun getDate(): List<String> = timeList
}