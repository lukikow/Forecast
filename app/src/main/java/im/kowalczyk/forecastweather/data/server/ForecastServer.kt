package im.kowalczyk.forecastweather.data.server

import im.kowalczyk.forecastweather.data.db.ForecastDb
import im.kowalczyk.forecastweather.domain.ForecastDataSource
import im.kowalczyk.forecastweather.domain.ForecastList

/**
 * Created by lkowalczyk on 01.08.2017.
 */

class ForecastServer(val dataMapper: ServerDataMapper =  ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}