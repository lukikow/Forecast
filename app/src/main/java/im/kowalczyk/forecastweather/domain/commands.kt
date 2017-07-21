package im.kowalczyk.forecastweather.domain

/**
 * Created by lukikow on 01.06.2017.
 */

interface Command<T> {
    fun execute(): T
}