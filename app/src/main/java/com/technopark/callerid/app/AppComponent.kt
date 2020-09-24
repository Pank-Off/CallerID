package com.technopark.callerid.app

import com.technopark.callerid.presenter.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(callLogPresenter: CallLogPresenter)
    fun inject(settingsPresenter: SettingsPresenter)
    fun inject(checkNumberPresenter: CheckNumberPresenter)
    fun inject(spamProtectionPresenter: SpamProtectionPresenter)
    fun inject(detailPresenter: DetailPresenter)
    fun inject(addNumberPresenter: AddNumberPresenter)
    fun inject(editNumberPresenter: EditNumberPresenter)
}