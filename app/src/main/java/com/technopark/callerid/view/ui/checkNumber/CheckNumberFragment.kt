package com.technopark.callerid.view.ui.checkNumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.technopark.callerid.R
import com.technopark.callerid.presenter.CheckNumberPresenter

//Здесь рабочая пока одна кнопка, для проверки что база работает
class CheckNumberFragment : Fragment(), CheckNumberView {
    private lateinit var checkNumberPresenter: CheckNumberPresenter
    private lateinit var button: MaterialButton
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

        button = view.findViewById(R.id.checkBtn)
        button.setOnClickListener {
            checkNumberPresenter.getTest()
        }
    }
}