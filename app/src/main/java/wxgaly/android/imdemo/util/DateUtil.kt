package wxgaly.android.imdemo.util

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by WXGALY on 2017/11/25.
 */
object DateUtil {

    fun getCurrentTimeString(): String {
        val simpleDataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return simpleDataFormat.format(Date())
    }

    fun getTimeString(timeStr: String): String {
        var simpleDataFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
        val date = simpleDataFormat.parse(timeStr)
        simpleDataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return simpleDataFormat.format(date)
    }


}