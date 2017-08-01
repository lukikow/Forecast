package im.kowalczyk.forecastweather.extension

/**
 * Created by lkowalczyk on 31.07.2017.
 */
import android.widget.TextView



var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)