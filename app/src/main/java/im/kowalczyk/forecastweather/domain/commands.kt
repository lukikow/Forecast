package im.kowalczyk.forecastweather.domain

/**
 * Created by lkowalczyk on 01.06.2017.
 */

interface Commnad<T> {
    fun execute(): T
}