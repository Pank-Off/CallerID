package com.technopark.callerid.view.ui.callLog

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.technopark.callerid.R
import com.technopark.callerid.app.App
import com.technopark.callerid.model.room.SpamerDao
import com.technopark.callerid.presenter.DetailPresenter
import com.technopark.callerid.view.ui.callLog.CallLogFragment.Companion.EXTRA_ICON
import com.technopark.callerid.view.ui.callLog.CallLogFragment.Companion.EXTRA_NAME
import com.technopark.callerid.view.ui.callLog.CallLogFragment.Companion.EXTRA_NUMBER

class DetailActivity : AppCompatActivity(), DetailView {

    lateinit var detailPresenter: DetailPresenter
    lateinit var nameView: TextView
    lateinit var numberView: TextView
    lateinit var call: ImageView
    lateinit var thisIsSpamBtn: MaterialButton
    val spamerDao: SpamerDao = App.getAppDatabase().spamerDao()

    companion object {
        val EXTRA = "EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        detailPresenter = DetailPresenter(this)

        initViews()
        setText()
        setOnImageClickListener()
        setOnSpamBtnClickListener()
    }

    private fun setOnSpamBtnClickListener() {
        if (intent.extras?.getInt(EXTRA_ICON) == R.drawable.bancircle) {
            thisIsSpamBtn.setText(R.string.this_is_not_spam)
        } else {
            thisIsSpamBtn.setText(R.string.this_is_spam)
        }
        thisIsSpamBtn.setOnClickListener {
            if (thisIsSpamBtn.text == resources.getString(R.string.this_is_spam)) {
                detailPresenter.addRecord(numberView.text.toString(), true, "From CallLog")
            } else {
                detailPresenter.removeRecord(numberView.text.toString())
            }
        }
    }

    private fun setOnImageClickListener() {
        call.setOnClickListener {
            val toCall = "tel:" + numberView.text
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(toCall)
            startActivity(intent)
        }
    }

    private fun setText() {
        val name: String? = intent.extras?.getString(EXTRA_NAME)
        val number: String? = intent.extras?.getString(EXTRA_NUMBER)
        nameView.text = name
        nameView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        numberView.text = number
    }

    private fun initViews() {
        nameView = findViewById(R.id.name)
        numberView = findViewById(R.id.number)
        call = findViewById(R.id.call)
        thisIsSpamBtn = findViewById(R.id.thisIsSpamBtn)
    }

    override fun addSuccessful() {
        Toast.makeText(applicationContext, "Spamer is added", Toast.LENGTH_LONG).show()
        thisIsSpamBtn.setText(R.string.this_is_not_spam)
    }

    override fun removeSuccessful() {
        Toast.makeText(applicationContext, "Spamer is deleted", Toast.LENGTH_LONG).show()
        thisIsSpamBtn.setText(R.string.this_is_spam)
    }
}