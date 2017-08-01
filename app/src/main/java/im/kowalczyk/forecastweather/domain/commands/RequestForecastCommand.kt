package im.kowalczyk.forecastweather.domain.commands

import im.kowalczyk.forecastweather.domain.Command
import im.kowalczyk.forecastweather.domain.ForecastList
import im.kowalczyk.forecastweather.domain.ForecastProvider

/**
 * Created by lkowalczyk on 01.08.2017.
 */

class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }
    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }

}
