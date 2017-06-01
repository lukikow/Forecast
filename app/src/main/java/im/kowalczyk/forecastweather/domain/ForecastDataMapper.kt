package im.kowalczyk.forecastweather.domain

import im.kowalczyk.forecastweather.data.Forecast
import im.kowalczyk.forecastweather.data.ForecastResult
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

import im.kowalczyk.forecastweather.domain.Forecast as ModelForecast

/**
 * Created by lkowalczyk on 01.06.2017.
 */

class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed {
            i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
//        return list.map {convertForecastItemToDomain(it)}
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}