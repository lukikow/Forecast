package im.kowalczyk.forecastweather.extension

/**
 * Created by lkowalczyk on 31.07.2017.
 */

fun <K,V : Any?> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({Pair(it.key, it.value!!)}).toTypedArray()