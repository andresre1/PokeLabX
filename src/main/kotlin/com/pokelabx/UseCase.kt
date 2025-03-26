package com.pokelabx

import io.micronaut.aop.Around
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Type

@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Bean
@Around
@Type(UseCaseLoggingInterceptor::class)
annotation class UseCase