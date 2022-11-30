package com.dewo.newsapp.utility

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Util {

    fun DateTimeHourAgo(dateTime: String?): String? {
        val prettyTime = PrettyTime(Locale.getDefault())
        var isTime: String? = null
        try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val date = dateTime?.let { simpleDateFormat.parse(it) }

            isTime = prettyTime.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return isTime
    }

    fun DateFormat(dateNews: String?): String? {
        val isDate: String?
        val dateFormat = SimpleDateFormat("MMMM dd, yyyy - HH:mm:ss", Locale(getCountry()))
        isDate = try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateNews)
            dateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            dateNews
        }
        return isDate
    }

    fun getCountry(): String {
        val locale = Locale.getDefault()
        val strCountry = locale.country
        return strCountry.lowercase(Locale.getDefault())
    }
}