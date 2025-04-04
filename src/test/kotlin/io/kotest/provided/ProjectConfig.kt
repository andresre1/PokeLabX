package io.kotest.provided

import com.pokelabx.PostgresContainer
import io.kotest.core.config.AbstractProjectConfig
import io.micronaut.test.extensions.kotest5.MicronautKotest5Extension

object ProjectConfig : AbstractProjectConfig() {
    override fun extensions() = listOf(MicronautKotest5Extension)

    override suspend fun beforeProject() {
        PostgresContainer.start()
    }

    override suspend fun afterProject() {
        PostgresContainer.stop()
    }
}