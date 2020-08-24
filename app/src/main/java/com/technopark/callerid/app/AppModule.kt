package com.technopark.callerid.app

import android.app.Application
import com.technopark.callerid.model.Model
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(_application: Application) {
    private var application: Application = _application

    @Singleton
    @Provides
    fun provideModel(): Model {
        return Model()
    }
}