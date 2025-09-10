package org.abora.plugin.azkarplugin.notification

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import org.abora.plugin.azkarplugin.notification.AzkarList.getRandomZekr
import org.abora.plugin.azkarplugin.notification.Constant.FONT_SIZE
import org.abora.plugin.azkarplugin.notification.Constant.NOTIFICATION_PERIOD_MS
import java.util.*
import kotlin.concurrent.fixedRateTimer

class NotificationService(private val project: Project) {
    private var timer: Timer? = null

    fun start() {
        timer = fixedRateTimer("Azkar-timer", initialDelay = 0L, period = NOTIFICATION_PERIOD_MS) {
            showNotification()
        }
    }

    private fun showNotification() {
        val styledText = "<html><div style='font-size:$FONT_SIZE;'>${getRandomZekr()}</div></html>"
        NotificationGroupManager.getInstance()
            .getNotificationGroup("AzkarNotificationGroup")
            .createNotification(styledText, NotificationType.INFORMATION)
            .notify(project)
    }

    fun stop() {
        timer?.cancel()
    }
}