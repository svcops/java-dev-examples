plugins {
    id("java-library")
    id("io.freefair.lombok") version "8.6"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

dependencies {
}