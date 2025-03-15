package com.pokelabx

import org.slf4j.bridge.SLF4JBridgeHandler
import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
            title = "demo",
            version = "0.0"
    )
)
object Api {
}
fun main(args: Array<String>) {
    SLF4JBridgeHandler.removeHandlersForRootLogger()
    SLF4JBridgeHandler.install()
	run(*args)
}

