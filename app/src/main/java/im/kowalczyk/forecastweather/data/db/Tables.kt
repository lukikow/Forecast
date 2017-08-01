package im.kowalczyk.forecastweather.data.db

/**
 * Created by lkowalczyk on 27.07.2017.
 */

object CityForecastTable {
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val ICON_URL = "iconUrl"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val CITY_ID = "cityId"
}