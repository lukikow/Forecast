package im.kowalczyk.forecastweather.extension

import java.text.DateFormat
import java.util.*

/**
 * Created by lkowalczyk on 01.08.2017.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
        val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
        return df.format(this)
}