package im.kowalczyk.forecastweather.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import im.kowalczyk.forecastweather.extension.App
import org.jetbrains.anko.db.*

/**
 * Created by lkowalczyk on 27.07.2017.
 */
class ForecastDbHelper(ctx : Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast_db"
        val DB_VERSION = 1
        val instance by lazy {ForecastDbHelper()}
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        p0?.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.dropTable(CityForecastTable.NAME, true)
        p0?.dropTable(DayForecastTable.NAME, true)
        onCreate(p0)
    }


}