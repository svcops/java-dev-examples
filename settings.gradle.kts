pluginManagement {
    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        gradlePluginPortal()
    }
}

rootProject.name = "java-dev-examples"

include("dev-api", "dev-biz")
