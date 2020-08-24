package com.technopark.callerid.app

import com.technopark.callerid.presenter.CallLogPresenter
import com.technopark.callerid.presenter.CheckNumberPresenter
import com.technopark.callerid.presenter.SettingsPresenter
import com.technopark.callerid.presenter.SpamProtectionPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(callLogPresenter: CallLogPresenter)
    fun inject(settingsPresenter: SettingsPresenter)
    fun inject(checkNumberPresenter: CheckNumberPresenter)
    fun inject(spamProtectionPresenter: SpamProtectionPresenter)
}