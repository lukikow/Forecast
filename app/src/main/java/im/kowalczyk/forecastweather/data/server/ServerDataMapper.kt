package im.kowalczyk.forecastweather.data.server

import im.kowalczyk.forecastweather.domain.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit

import im.kowalczyk.forecastweather.domain.Forecast as ModelForecast

/**
 * Created by lukikow on 01.06.2017.
 */

class ServerDataMapper {
    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed {
            i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
//        return list.map {convertForecastItemToDomain(it)}
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(-1, dt, weather[0].description, temp.max.toInt(), temp.min.toInt(), generateIconUrl(weather[0].icon))
    }

    private fun  generateIconUrl(icon: String): String = "http://openweathermap.org/img/w/$icon.png"
}