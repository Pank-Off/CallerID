package com.technopark.callerid.view.ui.callLog

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technopark.callerid.R
import com.technopark.callerid.presenter.CallLogPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CallLogFragment : Fragment(), CallLogView {

    private lateinit var callLogPresenter: CallLogPresenter
    private lateinit var contactsList: RecyclerView
    private val adapter = PhoneAdapter()
    private lateinit var mDividerItemDecoration: DividerItemDecoration
    private lateinit var oops: TextView
    private lateinit var sadEmotion: ImageView
    private lateinit var allowBtn: Button

    // Request code for READ_CALL_LOG. It can be any number > 0.
    private val PERMISSIONS_REQUEST_READ_CALL_LOG = 100

    companion object {
        const val EXTRA_NUMBER = "EXTRA_NUMBER"
        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_ICON = "EXTRA_ICON"
    }

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

        initViews(view)
        allowBtn.setOnClickListener {
            run {
                val intent: Intent = callLogPresenter.setOnClickAllowBtnListener(context)
                startActivity(intent)
            }
        }
        // showContacts()
    }

    private fun initViews(view: View) {
        contactsList = view.findViewById(R.id.contacts_list)
        oops = view.findViewById(R.id.notAllowPermission)
        sadEmotion = view.findViewById(R.id.sad_emotion)
        allowBtn = view.findViewById(R.id.allowBtn)
    }

    private fun showContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && requireContext().checkSelfPermission(
                Manifest.permission.READ_CALL_LOG
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CALL_LOG),
                PERMISSIONS_REQUEST_READ_CALL_LOG
            )
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            GlobalScope.launch(Dispatchers.IO) {
                callLogPresenter.getContactNames(context)
            }
        }
    }

    override fun setCallLog(contacts: ArrayList<PhoneBook>) {
        GlobalScope.launch(Dispatchers.Main) {
            val linearLayoutManager = LinearLayoutManager(context)
            contactsList.layoutManager = linearLayoutManager
            mDividerItemDecoration = DividerItemDecoration(
                contactsList.context,
                DividerItemDecoration.VERTICAL
            )
            Log.d("Coroutine", Thread.currentThread().name)
            contactsList.addItemDecoration(mDividerItemDecoration)

            adapter.attachListener(object : OnContactClickListener {
                override fun onClick(contact: PhoneBook) {

                    Toast.makeText(
                        context, "Был выбран пункт " + contact.getName(),
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(EXTRA_NAME, contact.getName())
                    intent.putExtra(EXTRA_NUMBER, contact.getNumber())
                    intent.putExtra(EXTRA_ICON, contact.getIcon())
                    startActivity(intent)
                }

            })
            adapter.setData(contacts)
            contactsList.adapter = adapter
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CALL_LOG) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                allowBtn.visibility = View.INVISIBLE
                sadEmotion.visibility = View.INVISIBLE
                oops.visibility = View.INVISIBLE
                showContacts()
            } else {
                oops.text = getString(R.string.oops_text)
                sadEmotion.setImageResource(R.drawable.sad_emotion)
                allowBtn.visibility = View.VISIBLE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context?.checkSelfPermission(
                Manifest.permission.READ_CALL_LOG
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            Log.d(Thread.currentThread().name, "onResume")
            showContacts()
        }
    }
}