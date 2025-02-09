plugins {
    kotlin("jvm") version "1.9.22"
    id("java")
    id("application")
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
    // Serenity and Cucumber dependencies
    testImplementation("net.serenity-bdd:serenity-core:3.1.5")
    testImplementation("net.serenity-bdd:serenity-cucumber:3.1.5")

    // Cucumber dependencies for JUnit 5 integration
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")

    // JUnit 5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // Other dependencies
    testImplementation("org.seleniumhq.selenium:selenium-java:4.14.1")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.6.2")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    systemProperty("cucumber.options", "--tags @regression --plugin json:build/cucumber-reports/cucumber.json")
}

tasks.withType<Test> {
    systemProperty("serenity.reports", "build/serenity-reports/json")
    maxParallelForks = Runtime.getRuntime().availableProcessors()  // Configure parallel test execution
}

// Adding the Main-Class attribute to the JAR manifest
tasks.jar {
    manifest {
        attributes["Main-Class"] = "runners.TestRunner"  // Ensure this points to your TestRunner class
    }
    from(sourceSets.main.get().output) // This ensures the classes from the main source set are included
}
