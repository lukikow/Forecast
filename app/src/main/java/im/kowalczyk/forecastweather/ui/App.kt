package im.kowalczyk.forecastweather.ui

import android.app.Application

/**
 * Created by lkowalczyk on 27.07.2017.
 */

class App : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}