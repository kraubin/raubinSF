plugins {
    kotlin("jvm") version "1.8.0"
    id("java")
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.1.5"
}

group = "com.salesforce.automation"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven {
        url = uri("https://plugins.xpandit.com/maven")
    }

}

dependencies {
    testImplementation("net.serenity-bdd:serenity-core:3.1.5")
    testImplementation("net.serenity-bdd:serenity-cucumber:3.1.5")
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit:7.14.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.14.1")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.6.2")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    systemProperty("cucumber.options", "--tags @regression")
}

tasks.withType<Test> {
    systemProperty("serenity.reports", "json")
}

