package im.kowalczyk.forecastweather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import im.kowalczyk.forecastweather.R
import im.kowalczyk.forecastweather.data.ForecastRequest
import im.kowalczyk.forecastweather.domain.Forecast
import im.kowalczyk.forecastweather.domain.RequestForecastCommand
import im.kowalczyk.forecastweather.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        val zipCode: String = "32-500"

        doAsync {
            //ForecastRequest(url).run()
            val result = RequestForecastCommand(zipCode).execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) {
                    toast(it.date)}
            }
        }
    }
}
