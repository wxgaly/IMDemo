package wxgaly.android.imdemo.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by WXGALY on 2017/11/25.
 */
object DateUtil {

    private val FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss"

    fun getCurrentTimeString(): String {
        val simpleDataFormat = SimpleDateFormat(FORMAT_STANDARD)
        return simpleDataFormat.format(Date())
    }

    fun getTimeString(timeStr: String): String {
        var simpleDataFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
        val date = simpleDataFormat.parse(timeStr)
        simpleDataFormat = SimpleDateFormat(FORMAT_STANDARD)
        return simpleDataFormat.format(date)
    }

    fun getTime(time: Long): String {
        var simpleDataFormat = SimpleDateFormat(FORMAT_STANDARD, Locale.CHINESE)
        return simpleDataFormat.format(Date(time))
    }

    fun getTimeByDate(date: Date): String {
        var simpleDataFormat = SimpleDateFormat(FORMAT_STANDARD, Locale.CHINESE)
        return simpleDataFormat.format(date)
    }
}