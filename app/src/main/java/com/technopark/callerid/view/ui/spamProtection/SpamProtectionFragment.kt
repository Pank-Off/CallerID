package com.technopark.callerid.view.ui.spamProtection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technopark.callerid.R
import com.technopark.callerid.presenter.SpamProtectionPresenter

class SpamProtectionFragment : Fragment(), SpamProtectionView {

    lateinit var spamProtectionPresenter: SpamProtectionPresenter
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
    }
}