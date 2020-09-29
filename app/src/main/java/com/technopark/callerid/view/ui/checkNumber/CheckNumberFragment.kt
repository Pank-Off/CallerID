package com.technopark.callerid.view.ui.checkNumber

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.technopark.callerid.R
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
    private var messageId = 1000

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
                Toast.makeText(context, "DataBase is updated", Toast.LENGTH_SHORT).show()
            } else {
                createNotification()
            }
        }
    }

    private fun createNotification() {
        val builder = context?.let {
            NotificationCompat.Builder(it, "2")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("DataBase is not update")
                .setContentText("Check your connection")
        }
        val notificationManager =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(messageId++, builder?.build())

    }
}