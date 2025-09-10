package org.abora.plugin.azkarplugin

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import org.abora.plugin.azkarplugin.notification.NotificationService

class MainActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        NotificationService(project).start()
    }
}