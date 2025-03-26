package com.pokelabx

import io.micronaut.runtime.Micronaut.run
import org.slf4j.bridge.SLF4JBridgeHandler

fun main(args: Array<String>) {
    SLF4JBridgeHandler.removeHandlersForRootLogger()
    SLF4JBridgeHandler.install()
    run(*args)
}

