package im.kowalczyk.forecastweather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import im.kowalczyk.forecastweather.domain.Forecast
import im.kowalczyk.forecastweather.domain.ForecastList
import im.kowalczyk.forecastweather.R
import org.jetbrains.anko.find

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
        private val iconView: ImageView = view.find(R.id.icon)
        private val dateView: TextView = view.find(R.id.date)
        private val descriptionView: TextView = view.find(R.id.description)
        private val maxTemperatureView: TextView = view.find(R.id.maxTemperature)
        private val minTemperatureView: TextView = view.find(R.id.minTemperature)

        /**initiate value
        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }
        */

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener {itemClick(this) }
            }
        }

    }
}

