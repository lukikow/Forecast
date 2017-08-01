package im.kowalczyk.forecastweather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import im.kowalczyk.forecastweather.R
import im.kowalczyk.forecastweather.domain.commands.RequestForecastCommand
import im.kowalczyk.forecastweather.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        val zipCode: Long = 32500

        doAsync {
            //ForecastRequest(url).run()
            val result = RequestForecastCommand(zipCode).execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result, {toast(it.description)})
            }
        }
    }
}
