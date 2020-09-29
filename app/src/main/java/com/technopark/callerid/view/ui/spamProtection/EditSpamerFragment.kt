package com.technopark.callerid.view.ui.spamProtection

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.technopark.callerid.R
import com.technopark.callerid.presenter.EditNumberPresenter
import com.technopark.callerid.view.ui.callLog.DetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditSpamerFragment : Fragment(), EditNumberView {

    private lateinit var editNumberPresenter: EditNumberPresenter
    private lateinit var numberOfPhone: TextInputEditText
    private lateinit var thisIsNotSpamBtn: MaterialButton
    private lateinit var itemEdit: MenuItem
    private lateinit var itemSave: MenuItem
    private lateinit var itemAdd: MenuItem
    private lateinit var addSpamerFragment: AddSpamerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editNumberPresenter = EditNumberPresenter(this)
        initViews(view)
        setOnClickSpamBtnListener()
        setTextOnEditText()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_spam_menu, menu)
        itemSave = menu.getItem(2)
        itemAdd = menu.getItem(1)
        itemEdit = menu.getItem(0)
        itemSave.isVisible = false
        itemAdd.isVisible = false
        itemEdit.isVisible = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        addSpamerFragment = AddSpamerFragment()
        val bundle = Bundle()
        bundle.putString(
            DetailActivity.EXTRA, requireActivity().intent.extras?.getString(
                DetailActivity.EXTRA
            )
        )
        addSpamerFragment.arguments = bundle
        fragmentTransaction.replace(R.id.fragment_container, addSpamerFragment)
        fragmentTransaction.commit()
        return true
    }

    private fun setTextOnEditText() {
        val number = requireArguments().getString(DetailActivity.EXTRA)
        numberOfPhone.setText(number)
    }

    private fun setOnClickSpamBtnListener() {
        thisIsNotSpamBtn.setOnClickListener { callAlertDialog() }
    }

    private fun callAlertDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setMessage("Do not consider this number spam?")
            .setPositiveButton("Delete", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    GlobalScope.launch(Dispatchers.IO) {
                        editNumberPresenter.removeRecord(numberOfPhone.text.toString())
                    }
                }

            }).setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun initViews(view: View) {
        numberOfPhone = view.findViewById(R.id.numberOfPhone)
        thisIsNotSpamBtn = view.findViewById(R.id.thisIsNotSpamBtn)
    }

    override fun removeSuccessful() {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(context, "Spamer is deleted", Toast.LENGTH_LONG).show()
            requireActivity().finish()
        }
    }
}