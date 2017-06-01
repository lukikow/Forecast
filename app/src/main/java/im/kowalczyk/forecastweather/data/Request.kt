package im.kowalczyk.forecastweather.data

import android.util.Log
import java.net.URL

/**
 * Created by lkowalczyk on 01.06.2017.
 */

class ForecastRequest(val url: String) {

    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }


}