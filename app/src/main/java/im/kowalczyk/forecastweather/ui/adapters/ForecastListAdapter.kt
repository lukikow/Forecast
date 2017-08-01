package im.kowalczyk.forecastweather.ui.adapters

import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.item_forecast.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import im.kowalczyk.forecastweather.domain.Forecast
import im.kowalczyk.forecastweather.domain.ForecastList
import im.kowalczyk.forecastweather.R
import java.text.DateFormat
import java.util.*

/**
 * Created by lukikow on 31.05.2017.
 */

class ForecastListAdapter(val weekForest: ForecastList,
                          val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
        //weekForest[p01] mean weekForest.get(p1)
        p0?.bindForecast(weekForest[p1])

    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0?.context).inflate(R.layout.item_forecast, p0, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForest.size()


    class ViewHolder(view: View,
                     val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toString()
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener {itemClick(this) }
            }
        }
    }
}

