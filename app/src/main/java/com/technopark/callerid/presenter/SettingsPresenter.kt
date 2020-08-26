package com.technopark.callerid.presenter

import android.content.Intent
import com.technopark.callerid.view.ui.settings.SettingsView

class SettingsPresenter(private var settingsView: SettingsView) {

    fun setOnShareBtnClickListener(): Intent {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val shareBody = "Hi! I'm using Caller ID!"
        val shareSub = "Share sub"
        intent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
        intent.putExtra(Intent.EXTRA_TEXT, shareBody)
        return intent
    }
}