plugins {
    kotlin("jvm") version "1.9.22"
    id("java")
    id("application")
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.1.5"
    id("com.github.johnrengelman.shadow") version "7.0.0"  // Shadow plugin for fat JAR
}

group = "com.salesforce.automation"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    // Serenity and Cucumber dependencies
    testImplementation("net.serenity-bdd:serenity-core:3.1.5")
    testImplementation("net.serenity-bdd:serenity-cucumber:3.1.5")
    testImplementation("io.cucumber:cucumber-core:7.14.0")
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")

    // JUnit 5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // Other dependencies
    testImplementation("org.seleniumhq.selenium:selenium-java:4.14.1")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.6.2")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("org.slf4j:slf4j-api:1.7.31")
    implementation("org.slf4j:slf4j-simple:1.7.32")
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java")
        }
    }
    test {
        java {
            srcDirs("src/test/java")
        }
    }
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

// ✅ Define the main class explicitly
application {
    mainClass.set("runners.TestRunner")
}

tasks.shadowJar {
    archiveFileName.set("SalesForceAuto-all.jar")
    from(sourceSets.main.get().output)
    from(sourceSets.test.get().output)  // Ensure test classes (TestRunner) are included
    configurations = listOf(project.configurations.runtimeClasspath.get(), project.configurations.testRuntimeClasspath.get())
    manifest {
        attributes["Main-Class"] = "runners.TestRunner" // Ensure this points to your TestRunner class
    }
}



tasks.jar {
    manifest {
        attributes["Main-Class"] = "runners.TestRunner"  // Ensure this points to your TestRunner class
    }
    from(sourceSets.main.get().output)  // Include the main source set
    from(sourceSets.test.get().output)  // Include the test source set
}
