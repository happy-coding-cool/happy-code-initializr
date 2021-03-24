buildscript {

    repositories {
            mavenCentral()
    }

    dependencies {
        classpath "io.spring.gradle:dependency-management-plugin:1.0.10.RELEASE"
        classpath "org.springframework.boot:spring-boot-gradle-plugin:2.3.2.RELEASE"
    }
}

rootProject.name = '${projectMetadata.artifact}'