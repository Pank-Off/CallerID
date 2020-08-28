package com.technopark.callerid.view.ui.checkNumber

interface CheckNumberView {

    fun validNumber()
    fun invalidNumber()
    fun isSpam(isSpam: String)
}