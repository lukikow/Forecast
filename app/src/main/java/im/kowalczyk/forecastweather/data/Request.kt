package im.kowalczyk.forecastweather.data

import android.util.Log
import java.net.URL

/**
 * Created by lkowalczyk on 01.06.2017.
 */

class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                          "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }



}