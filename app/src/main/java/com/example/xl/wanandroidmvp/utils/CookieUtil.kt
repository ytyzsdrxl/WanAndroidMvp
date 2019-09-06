package com.example.xl.wanandroidmvp.utils

import android.content.SharedPreferences
import com.example.xl.wanandroidmvp.app.MyApplication

import java.util.*

object CookieUtil {

    fun encodeCookie(cookies: MutableList<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies.map { cookie ->
            cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }.forEach {
            it.filterNot { item ->
                set.contains(item)
            }.forEach { item ->
                set.add(item)
            }
        }
        val iterator: MutableIterator<String> = set.iterator()
        while (iterator.hasNext()) {
            val cookie: String = iterator.next()
            sb.append(cookie).append(";")
        }
        val last: Int = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }

    /**
     * add cookie in [SharedPreferences]
     */
    fun saveCookie(cookies: String) {
        PreferencesUtil.putString(MyApplication.getContext(),"cookie",cookies);
    }
}

