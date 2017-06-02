package im.kowalczyk.forecastweather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import im.kowalczyk.forecastweather.domain.ForecastList

/**
 * Created by lkowalczyk on 31.05.2017.
 */

class ForecastListAdapter(val weekForest: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
        with(weekForest.dailyForecast[p1]) {
            p0?.textView?.text = "$date - $description - $high/$low"
        }
    }


    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        return ViewHolder(TextView(p0?.context))
    }

    override fun getItemCount(): Int = weekForest.dailyForecast.size


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}