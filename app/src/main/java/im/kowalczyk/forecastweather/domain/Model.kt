package im.kowalczyk.forecastweather.domain

/**
 * Created by lkowalczyk on 01.06.2017.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)