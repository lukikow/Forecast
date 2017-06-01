package im.kowalczyk.forecastweather

import android.util.Log
import java.net.URL

/**
 * Created by lkowalczyk on 01.06.2017.
 */

class Request(val url: String) {

    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}