package com.technopark.callerid.view.ui.spamProtection

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.technopark.callerid.R
import com.technopark.callerid.presenter.AddNumberPresenter
import com.technopark.callerid.presenter.EditNumberPresenter
import com.technopark.callerid.view.ui.callLog.DetailActivity.Companion.EXTRA
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class AddSpamerFragment : Fragment(), AddNumberView {

    private lateinit var addNumberPresenter: AddNumberPresenter
    private lateinit var itemAdd: MenuItem
    private lateinit var itemEdit: MenuItem
    private lateinit var itemSave: MenuItem
    private lateinit var numberOfPhoneEditText: TextInputEditText
    private lateinit var comment: TextInputEditText
    private lateinit var correctPhone: String
    private lateinit var oldNumber: String

    private  var newNumber:String=""
    private var validNumber: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_number, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNumberPresenter = AddNumberPresenter(this)

        initViews(view)
        setTextOnEditText()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_spam_menu, menu)
        itemSave = menu.getItem(2)
        itemAdd = menu.getItem(1)
        itemEdit = menu.getItem(0)
        if (Objects.requireNonNull(
                requireActivity().intent.extras
            )?.getString(EXTRA) == ""
        ) {
            itemSave.isVisible = false
            itemEdit.isVisible = false
            itemAdd.isVisible = true
        } else {
            itemAdd.isVisible = false
            itemEdit.isVisible = false
            itemSave.isVisible = true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.action_add == item.itemId) {
            if (Objects.requireNonNull(numberOfPhoneEditText.text).toString() != "") {
                val number = numberOfPhoneEditText.text.toString()
                addNumberPresenter.checkValidNumber(number)
                if (validNumber) {
                    GlobalScope.launch(Dispatchers.IO) {
                        addNumberPresenter.addRecord(number, true, getComment())
                    }
                    requireActivity().finish()
                }
            } else {
                showAlert()
            }
        }
        if (R.id.action_save == item.itemId) {
            if (Objects.requireNonNull(numberOfPhoneEditText.text).toString() != "") {
                val oldNumber = arguments?.getString(EXTRA)
                newNumber = numberOfPhoneEditText.text.toString()
                addNumberPresenter.checkValidNumber(newNumber)
                if (validNumber) {
                    val newComment = getComment()
                    Log.e("newComment",newComment)
                    if (oldNumber != null) {
                        GlobalScope.launch(Dispatchers.IO) {
                            addNumberPresenter.replaceRecord(correctPhone, newComment)
                        }
                    }
                }
            } else {
                showAlert()
            }
        }
        return true
    }

    private fun showAlert() {
        val builder =
            context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Failed to save an entry")?.setMessage("Please input number of phone")
            ?.setPositiveButton(
                "Ok"
            ) { _, _ -> }
        builder?.create()?.show()
    }

    private fun getComment(): String {
        return Objects.requireNonNull(comment.text).toString()
    }

    private fun setTextOnEditText() {
        try {
            oldNumber = requireArguments().getString(EXTRA).toString()
            numberOfPhoneEditText.setText(oldNumber)
        } catch (e: IllegalStateException) {
            numberOfPhoneEditText.setText("")
        }
    }

    private fun initViews(view: View) {
        numberOfPhoneEditText = view.findViewById(R.id.numberOfPhone)
        comment = view.findViewById(R.id.comment)
    }

    override fun validNumber() {
        numberOfPhoneEditText.error = null
        validNumber = true
        correctPhone = newNumber
    }

    override fun invalidNumber() {
        numberOfPhoneEditText.error = "Некорректный ввод"
        validNumber = false
    }

    override fun addSuccessful() {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(context, "Spamer is added", Toast.LENGTH_LONG).show()
        }
    }

    override fun addFailed() {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(context, "Sorry, duplicate", Toast.LENGTH_LONG).show()
        }
    }

    override fun replaceSuccessful() {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(context, "Replace", Toast.LENGTH_LONG).show()
            requireActivity().finish()
        }
    }

}