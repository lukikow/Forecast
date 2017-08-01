package im.kowalczyk.forecastweather.domain

/**
 * Created by lkowalczyk on 01.08.2017.
 */

interface ForecastDataSource{
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}