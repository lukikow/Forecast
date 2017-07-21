package im.kowalczyk.forecastweather.domain

import im.kowalczyk.forecastweather.data.ForecastRequest

/**
 * Created by lukikow on 01.06.2017.
 */

class RequestForecastCommand(val zipCode: String):  Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}