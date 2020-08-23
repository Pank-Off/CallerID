package com.technopark.callerid.view.ui.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.google.android.material.switchmaterial.SwitchMaterial
import com.technopark.callerid.R
import com.technopark.callerid.presenter.SettingsPresenter

class SettingsFragment : Fragment(), SettingsView {

    private lateinit var settingsPresenter: SettingsPresenter
    private lateinit var shareButton: Button
    private lateinit var darkMode: SwitchMaterial
    private lateinit var text: TextView

    companion object {
        const val KEY: String = "isChecked"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingsPresenter = SettingsPresenter(this)
        initViews(view)

        setOnShareBtnClickListener()
        setOnSwitchCheckedChangeListener()

        val sharedPreferences = requireActivity().getSharedPreferences(
            requireActivity().packageName,
            Context.MODE_PRIVATE
        )
        darkMode.isChecked = sharedPreferences.getBoolean(KEY, false)
    }

    private fun setOnSwitchCheckedChangeListener() {
        darkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                text.setText(R.string.dark_mode_is_enabled)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                val editor = requireActivity().getSharedPreferences(
                    requireActivity().packageName,
                    Context.MODE_PRIVATE
                ).edit()
                editor.putBoolean(KEY, true)
                editor.apply()
            } else {
                text.setText(R.string.light_mode_is_enabled)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                val editor = requireActivity().getSharedPreferences(
                    requireActivity().packageName,
                    Context.MODE_PRIVATE
                ).edit()
                editor.putBoolean(KEY, false)
                editor.apply()
            }
        }
    }

    private fun setOnShareBtnClickListener() {
        shareButton.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val shareBody = "Hi! I'm using Caller ID!"
            val shareSub = "Share sub"
            intent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, "Share using"))
        }
    }

    private fun initViews(view: View) {
        shareButton = view.findViewById(R.id.shareButton)
        darkMode = view.findViewById(R.id.dark_mode)
        text = view.findViewById(R.id.settingsText)
    }
}