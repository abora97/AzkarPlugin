package org.abora.plugin.azkarplugin

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.startup.StartupActivity
import kotlin.jvm.java

class DialogActivity : ProjectActivity {

    private val log = Logger.getInstance(DialogActivity::class.java)

    override suspend fun execute(project: Project) {
        log.info("🚀 MyStartupActivity is running for project: ${project.name}")
        NotificationService(project).start()
        NotificationGroupManager.getInstance()
            .getNotificationGroup("MyPluginNotifications")
            .createNotification(
                "Hello Mahmoud 👋",
                "Your plugin is running successfully 🎉",
                NotificationType.INFORMATION
            )
            .notify(project)
    }
}