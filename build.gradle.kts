subprojects {
    version = Versions.PROJECT_VERSION

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    configurations.configureEach {
        resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    }

    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url = uri("https://af.nginx.co/artifactory/dev-libs") }
        mavenCentral()
    }

}
