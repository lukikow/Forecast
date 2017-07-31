package im.kowalczyk.forecastweather.domain

/**
 * Created by lukikow on 01.06.2017.
 */

data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)