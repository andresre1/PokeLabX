package com.pokelabx

import org.slf4j.LoggerFactory
import org.testcontainers.containers.PostgreSQLContainer

class PostgresContainer : PostgreSQLContainer<PostgresContainer>("postgres:15") {
    companion object {
        private lateinit var instance: PostgresContainer
        private val log = LoggerFactory.getLogger(PostgresContainer::class.java)

        fun start() {
            if (!Companion::instance.isInitialized) {
                log.info("🟢 Starting PostgreSQL container... 🚀")
                instance = PostgresContainer()
                instance.start()

                log.info("✅ PostgreSQL container started at: ${instance.jdbcUrl} 🌍")
                System.setProperty("datasources.default.url", instance.jdbcUrl)
                System.setProperty("datasources.default.username", instance.username)
                System.setProperty("datasources.default.password", instance.password)
            }
        }

        fun stop() {
            log.info("🔴 Stopping PostgreSQL container... 🛑")
            instance.stop()
            log.info("✅ PostgreSQL container stopped. 🛑")
        }
    }
}