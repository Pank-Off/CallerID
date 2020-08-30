package com.technopark.callerid.view.ui.spamProtection

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
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

    private lateinit var searchView: SearchView
    private lateinit var queryTextListener: SearchView.OnQueryTextListener

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
        //   setOnFloatingBtnClick()
        setHasOptionsMenu(true)
    }

    private fun initViews(view: View) {
        floatingButton = view.findViewById(R.id.floatingBtn)
        spamList = view.findViewById(R.id.spam_list)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search)
        // Associate searchable configuration with the SearchView
        val searchManager =
            requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = searchItem.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
        queryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.i("onQueryTextSubmit", query)
                adapter.filter.filter(query)
                Log.i("ItemCount()", adapter.itemCount.toString())
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Log.i("onQueryTextChange", newText)
                adapter.filter.filter(newText)
                Log.i("ItemCount()", adapter.itemCount.toString())
                return true
            }

        }
        searchView.setOnQueryTextListener(queryTextListener)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search) {
            return false
        }
        searchView.setOnQueryTextListener(queryTextListener)
        return super.onOptionsItemSelected(item)
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