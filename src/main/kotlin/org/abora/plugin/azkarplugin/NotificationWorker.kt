package org.abora.plugin.azkarplugin

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import java.util.*
import kotlin.concurrent.fixedRateTimer

class NotificationService(private val project: Project) {
    private var timer: Timer? = null

    fun start() {
        timer = fixedRateTimer("demo-timer", initialDelay = 0L, period = 10_000L) {
            showNotification()
        }
    }

    private fun showNotification() {
        NotificationGroupManager.getInstance()
            .getNotificationGroup("DemoNotificationGroup")
            .createNotification("", NotificationType.INFORMATION)
            .notify(project)
    }

    fun stop() {
        timer?.cancel()
    }
}