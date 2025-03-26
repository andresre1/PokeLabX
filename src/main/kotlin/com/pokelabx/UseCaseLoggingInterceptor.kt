package com.pokelabx

import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import org.slf4j.LoggerFactory
import jakarta.inject.Singleton
import kotlin.system.measureTimeMillis

@Singleton
class UseCaseLoggingInterceptor : MethodInterceptor<Any, Any> {

    companion object {
        private val log = LoggerFactory.getLogger(UseCaseLoggingInterceptor::class.java)
    }

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {
        val targetClass = context.declaringType.name
        val methodName = context.executableMethod.name
        val params = context.parameterValues.joinToString(", ")
        
        log.info("Executing use case: {}#{} with parameters: [{}]", targetClass, methodName, params)

        val result: Any
        val elapsedTime = measureTimeMillis {
            result = context.proceed()
        }

        log.info("Finished executing use case: {}#{} in {}ms", targetClass, methodName, elapsedTime)
        return result
    }
}
