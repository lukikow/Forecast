package im.kowalczyk.forecastweather.domain

import im.kowalczyk.forecastweather.data.server.ForecastRequest

/**
 * Created by lukikow on 01.06.2017.
 */

class RequestForecastCommand(val zipCode: Long):  Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }

}