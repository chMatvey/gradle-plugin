package com.github.chMatvey.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class ShowFileContentTask : DefaultTask() {
    @get:Input
    lateinit var destination: String

    @TaskAction
    fun show() {
        println(destination)
    }
}
