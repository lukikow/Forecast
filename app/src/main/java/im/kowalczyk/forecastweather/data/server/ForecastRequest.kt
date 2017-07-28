package im.kowalczyk.forecastweather.data.server

import android.util.Log
import java.net.URL
import com.google.gson.Gson

/**
 * Created by lukikow on 01.06.2017.
 */

class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                          "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d("TAG", "zip code: " + zipCode)
        return  Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}