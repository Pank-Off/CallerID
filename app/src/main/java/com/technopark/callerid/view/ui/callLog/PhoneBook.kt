package com.technopark.callerid.view.ui.callLog

class PhoneBook(
    private var icon: Int,
    private var name: String,
    private var number: String
) {

    fun getName() = name
    fun getIcon() = icon
    fun getNumber(): String = number

    fun setIcon(icon: Int) {
        this.icon = icon
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setNumber(number: String) {
        this.number = number
    }

}