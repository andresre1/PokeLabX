plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.25"
    id("com.google.devtools.ksp") version "1.9.25-1.0.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.4"
    id("io.micronaut.test-resources") version "4.4.4"
    id("io.micronaut.aot") version "4.4.4"
}

version = "0.1"
group = "com.pokelabx"

val kotlinVersion=project.properties.get("kotlinVersion")

repositories {
    mavenCentral()
}

dependencies {
    ksp("io.micronaut.data:micronaut-data-processor")
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.openapi:micronaut-openapi")
    implementation("io.micronaut:micronaut-aop")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.data:micronaut-data-tx-hibernate")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.liquibase:micronaut-liquibase")
//    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
//    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.slf4j:jul-to-slf4j")
    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("io.micronaut.openapi:micronaut-openapi-annotations")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
//    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.yaml:snakeyaml")
    testImplementation("io.micronaut:micronaut-http-client")
    testImplementation("io.micronaut.test:micronaut-test-rest-assured")
    testImplementation("io.micronaut.testresources:micronaut-test-resources-extensions-junit-platform")
    testImplementation("org.mockito:mockito-core")
    testImplementation("io.micronaut.test:micronaut-test-kotest5:${property("kotestVersion")}")
    testImplementation("io.mockk:mockk:${property("mockkVersion")}")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:${property("kotestJunit5JvmVersion")}")
    testImplementation("org.wiremock:wiremock:${property("wiremockVersion")}")
}


application {
    mainClass = "com.pokelabx.ApplicationKt"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("com.pokelabx.*")
    }
    aot {
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


