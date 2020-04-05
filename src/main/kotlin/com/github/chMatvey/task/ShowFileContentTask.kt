package com.github.chMatvey.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option
import java.io.File

open class ShowFileContentTask : DefaultTask() {
    @get:Input
    @set:Option(option = "path", description = "Path to file")
    var destination: String? = null

    private val skipRegex = Regex("(?i)^#skip *\\d+.*\$")
    private val numberRegex = Regex("\\d+")

    @TaskAction
    fun show() {
        if (destination != null) {
            val file = File(destination!!)

            if (file.exists()) {
                var skipStrCount = 0;

                file.forEachLine {
                    when {
                        skipStrCount > 0 -> {
                            skipStrCount--
                        }
                        skipRegex.matches(it) -> {
                            numberRegex.find(it)?.run {
                                skipStrCount = this.value.toIntOrNull()?:0
                            }
                        }
                        else -> {
                            println(it)
                        }
                    }
                }
            } else {
                println("File does not exist")
            }
        } else {
            println("Please, specify the path to the file [--path=]")
        }
    }
}
