package org.abora.plugin.azkarplugin.notification

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.abora.plugin.azkarplugin.model.Zekr
import java.io.InputStreamReader

object AzkarList {

    private val azkar: List<Zekr> by lazy {
        val stream = javaClass.classLoader.getResourceAsStream("azkar.json")
            ?: throw IllegalStateException("azkar_only.json not found in resources!")

        val reader = InputStreamReader(stream, Charsets.UTF_8)
        val type = object : TypeToken<List<Zekr>>() {}.type
        Gson().fromJson(reader, type)
    }

    fun getRandomZekr(): String {
        return azkar.random().text
    }

}