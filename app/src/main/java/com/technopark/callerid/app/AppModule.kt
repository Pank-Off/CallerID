package com.technopark.callerid.app

import android.app.Application
import dagger.Module

@Module
class AppModule(_application: Application) {

    private var application: Application = _application

}