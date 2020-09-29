package com.technopark.callerid.view.ui.checkNumber

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.technopark.callerid.R
import com.technopark.callerid.model.FirebaseWorker
import com.technopark.callerid.presenter.CheckNumberPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CheckNumberFragment : Fragment(), CheckNumberView {
    private lateinit var appContext: Context
    private lateinit var checkNumberPresenter: CheckNumberPresenter
    private lateinit var checkBtn: MaterialButton
    private lateinit var numberOfPhoneEditText: TextInputEditText
    private lateinit var isSpamTextfield: TextView
    private var validNumber: Boolean = false
    private lateinit var updateDB: MaterialButton
    //private lateinit var fireBaseWorker: FirebaseWorker

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

        appContext = requireContext()
        initViews(view)
        setOnCheckBtnClickListener()

        setOnUpdateDBClickListener()
    }

    private fun initViews(view: View) {
        checkBtn = view.findViewById(R.id.checkBtn)
        numberOfPhoneEditText = view.findViewById(R.id.numberOfPhone)
        isSpamTextfield = view.findViewById(R.id.isSpamTextView)
        updateDB = view.findViewById(R.id.updateDB)
    }

    private fun setOnCheckBtnClickListener() {
        checkBtn.setOnClickListener {
            val number: String = numberOfPhoneEditText.text.toString()
            checkNumberPresenter.checkValidNumber(number)
            if (validNumber) {
                Toast.makeText(context, "Good", Toast.LENGTH_LONG).show()
                GlobalScope.launch(Dispatchers.IO) {
                    checkNumberPresenter.getSingleUserInfo()
                }
            } else {
                Toast.makeText(context, "notGood", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setOnUpdateDBClickListener() {
        updateDB.setOnClickListener {
            Toast.makeText(context, "DataBase are updating...", Toast.LENGTH_LONG).show()
            GlobalScope.launch(Dispatchers.IO) {
                checkNumberPresenter.downloadDBFromfireBase(context)
            }
        }
    }

    override fun validNumber() {
        numberOfPhoneEditText.error = null
        validNumber = true
    }

    override fun invalidNumber() {
        numberOfPhoneEditText.error = "Некорректный ввод"
        validNumber = false
    }

    override fun isSpam(isSpam: String) {
        GlobalScope.launch(Dispatchers.Main) {
            isSpamTextfield.text = isSpam
        }
    }

    override fun areUpdateDB(areUpdate: Boolean) {
        Log.e(javaClass.simpleName + " areUpdate", areUpdate.toString())
        GlobalScope.launch(Dispatchers.Main) {
            if (areUpdate) {
                Toast.makeText(context, "DataBase is updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "DataBase is not updated", Toast.LENGTH_SHORT).show();
            }
        }
    }
}