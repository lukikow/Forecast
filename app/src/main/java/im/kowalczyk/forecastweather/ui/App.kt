package im.kowalczyk.forecastweather.ui

import android.app.Application
import im.kowalczyk.forecastweather.ui.utils.DelegatesExt

/**
 * Created by lkowalczyk on 27.07.2017.
 */

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}