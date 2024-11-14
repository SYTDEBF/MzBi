package org.mz.mzbi.tools

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import java.math.RoundingMode
import java.text.DecimalFormat
import java.time.Instant
import java.time.format.DateTimeFormatter


object VideoDataConvert {

    fun conToTenThousand(num: Int):String {
        if (num<=9999){
            return "$num"
        }else{
            val format = DecimalFormat("#.##")
            //舍弃规则，RoundingMode.FLOOR表示直接舍弃。
            format.roundingMode = RoundingMode.FLOOR
            return format.format(num.toFloat()/10000) +"万"
        }
    }
    fun conDurationTo(duration: Int):String {
        val hour:Int = duration/3600
        val min:Int = (duration%3600)/60
        val s: Int = (duration % 3600) % 60
        return if (hour==0&&duration>60){
            "${min}分钟"
        }else if (min==0&&duration<60) {
            "${s}秒"
        }else if (hour>0){
            "${hour}小时${min}分"
        }else{
            "${hour}:${min}:${s}"
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun conUnixTimeToISO(time: Int):String {
        val dateStr = DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(time.toLong())).toString()
        val parsedInstant = kotlinx.datetime.Instant.parse(dateStr)
        //val thisTime: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val perTime = parsedInstant.periodUntil(Clock.System.now(),TimeZone.UTC)
        if (perTime.years>0){
            return "${perTime.years}年前"
        }else if (perTime.months>0){
            return "${perTime.months}月前"
        }else if (perTime.days>0){
            return "${perTime.days}天前"
        }else if (perTime.minutes>0){
            return "${perTime.minutes}分钟前"
        }else if (perTime.seconds>0){
            return "${perTime.seconds}秒前"
        }
        return "刚刚"

    }


}
@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>){
    println(VideoDataConvert.conUnixTimeToISO(1729850100))
}