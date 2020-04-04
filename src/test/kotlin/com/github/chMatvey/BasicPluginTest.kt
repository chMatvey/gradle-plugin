package com.github.chMatvey

import com.github.chMatvey.task.ShowFileContentTask
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BasicPluginTest {
    @Test
    fun basicPluginAddShowFileContentToProject() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply(BasicPlugin::class.java)

        Assertions.assertTrue(project.tasks.findByName("show") is ShowFileContentTask)
    }
}
