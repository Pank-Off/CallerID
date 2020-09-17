package com.technopark.callerid.view.ui.spamProtection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.technopark.callerid.R
import com.technopark.callerid.view.ui.callLog.DetailActivity.Companion.EXTRA

class AddNumberActivity : AppCompatActivity() {

    private lateinit var addSpamerFragment: AddSpamerFragment
    private lateinit var editSpamerFragment: EditSpamerFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_and_edit)
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction();
        if (intent.extras?.getString(EXTRA) == ""
        ) {
            addSpamerFragment = AddSpamerFragment()
            fragmentTransaction.replace(R.id.fragment_container, addSpamerFragment)
        } else {
            editSpamerFragment = EditSpamerFragment()
            val bundle = Bundle()
            bundle.putString(EXTRA, intent.extras!!.getString(EXTRA))
            editSpamerFragment.arguments = bundle
            fragmentTransaction.replace(R.id.fragment_container, editSpamerFragment)
        }
        fragmentTransaction.commit()
    }
}