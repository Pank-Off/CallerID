package com.technopark.callerid.view.ui.spamProtection

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.technopark.callerid.R
import com.technopark.callerid.model.room.Spamer
import com.technopark.callerid.presenter.SpamProtectionPresenter
import com.technopark.callerid.view.ui.callLog.OnItemClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SpamProtectionFragment : Fragment(), SpamProtectionView {

    private lateinit var spamProtectionPresenter: SpamProtectionPresenter
    private lateinit var floatingButton: FloatingActionButton

    private lateinit var spamList: RecyclerView
    private lateinit var spamers: List<Spamer>
    private lateinit var mDividerItemDecoration: DividerItemDecoration
    private lateinit var adapter: SpamAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spam_protection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spamProtectionPresenter = SpamProtectionPresenter(this)
        initViews(view)
    }

    private fun initViews(view: View) {
        floatingButton = view.findViewById(R.id.floatingBtn)
        spamList = view.findViewById(R.id.spam_list)
    }

    private fun showSpam() {
        Log.d("ShowSpam", "spam")
        GlobalScope.launch(Dispatchers.IO) {
            spamers = spamProtectionPresenter.getDataFromDB()
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(javaClass.simpleName, spamers.toString())
            val linearLayoutManager = LinearLayoutManager(context)
            spamList.layoutManager = linearLayoutManager
            mDividerItemDecoration = DividerItemDecoration(
                spamList.context,
                DividerItemDecoration.VERTICAL
            )
            spamList.addItemDecoration(mDividerItemDecoration)
            adapter = SpamAdapter(spamers, object : OnItemClickListener {
                override fun onClick(position: Int) {
                    Toast.makeText(context, spamers[position].phoneNumber, Toast.LENGTH_SHORT)
                        .show()
                }
            })
            spamList.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        showSpam()
    }
}