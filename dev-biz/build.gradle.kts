plugins {
    id("java")
    id("org.springframework.boot") version Versions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version "1.1.6"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly.configure {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {

    implementation(platform("io.intellij.commons:dev-dependencies:${Versions.DEV_COMMSON_VERSION}"))

    implementation("io.intellij.commons:dev-commons-config")

    implementation("io.intellij.commons.starters:dev-spring-boot-starter-web")

    implementation(project(":dev-api"))

}
