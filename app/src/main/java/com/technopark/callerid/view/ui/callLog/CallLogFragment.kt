package com.technopark.callerid.view.ui.callLog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technopark.callerid.R
import com.technopark.callerid.presenter.CallLogPresenter

class CallLogFragment : Fragment(), CallLogView {

    lateinit var callLogPresenter: CallLogPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_caller, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callLogPresenter = CallLogPresenter(this)
        callLogPresenter.getText()

    }

    override fun setText(text: String) {
        Log.d(javaClass.simpleName, text)
    }

}