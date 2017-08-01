package im.kowalczyk.forecastweather.extension

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by lkowalczyk on 01.08.2017.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)