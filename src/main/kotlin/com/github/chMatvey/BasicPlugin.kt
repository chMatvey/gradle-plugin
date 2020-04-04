package com.github.chMatvey

import com.github.chMatvey.task.ShowFileContentTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class BasicPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("show", ShowFileContentTask::class.java)
    }
}
