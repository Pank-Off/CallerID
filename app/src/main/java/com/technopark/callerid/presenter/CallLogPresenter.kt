package com.technopark.callerid.presenter

import com.technopark.callerid.view.ui.callLog.CallLogView

class CallLogPresenter(private var callLogView: CallLogView) {

    fun getText() {
        callLogView.setText("textFromPresenter")
    }
}