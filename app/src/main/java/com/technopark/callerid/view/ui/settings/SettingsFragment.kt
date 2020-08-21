package com.technopark.callerid.view.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technopark.callerid.R
import com.technopark.callerid.presenter.SettingsPresenter

class SettingsFragment : Fragment(), SettingsView {

    lateinit var settingsPresenter: SettingsPresenter
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
    }
}