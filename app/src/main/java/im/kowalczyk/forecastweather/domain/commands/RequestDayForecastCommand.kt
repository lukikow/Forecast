package im.kowalczyk.forecastweather.domain.commands

import im.kowalczyk.forecastweather.domain.Command
import im.kowalczyk.forecastweather.domain.Forecast
import im.kowalczyk.forecastweather.domain.ForecastProvider

/**
 * Created by lkowalczyk on 01.08.2017.
 */

class RequestDayForecastCommand(
                val id: Long,
                val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

        override fun execute() = forecastProvider.requestForecast(id)
}