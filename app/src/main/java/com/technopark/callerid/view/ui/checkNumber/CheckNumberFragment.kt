package com.technopark.callerid.view.ui.checkNumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technopark.callerid.R
import com.technopark.callerid.presenter.CheckNumberPresenter

class CheckNumberFragment : Fragment(), CheckNumberView {
    lateinit var checkNumberPresenter: CheckNumberPresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkNumberPresenter = CheckNumberPresenter(this)
    }
}