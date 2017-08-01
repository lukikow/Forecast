package im.kowalczyk.forecastweather.data.db

import im.kowalczyk.forecastweather.domain.ForecastDataSource
import im.kowalczyk.forecastweather.domain.ForecastList
import im.kowalczyk.forecastweather.extension.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import kotlin.collections.HashMap

/**
 * Created by lkowalczyk on 28.07.2017.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance, val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList{ DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${(CityForecastTable.ID)} = ?", zipCode.toString())
                .parseOpt{CityForecast(HashMap(it), dailyForecast)}

        if(city != null) dataMapper.convertToDomain(city) else null
    }

    override fun requestDayForecast(id: Long) = forecastDbHelper.use{
        val forecast = select(DayForecastTable.NAME).byId(id)
                .parseOpt { DayForecast(HashMap(it)) }

        if (forecast != null) dataMapper.convertDayToDomain(forecast) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach{insert(DayForecastTable.NAME, *it.map.toVarargArray())}
        }
    }

}