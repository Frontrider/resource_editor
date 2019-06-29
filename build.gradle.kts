import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        // this plugin
        classpath("org.jsonschema2pojo:jsonschema2pojo-gradle-plugin:1.0.1")
        // add additional dependencies here if you wish to reference instead of generate them (see example directory)

    }
}

plugins {
    java
    kotlin("jvm") version "1.3.30"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.40"

    application
}
apply(plugin = "jsonschema2pojo")

application {
    mainClassName = "hu.frontrider.modeleditor.ModelEditor"
}

allOpen {
    annotation("Mockable")
}

group = "hu.frontrider.mod-editor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("http://server.bbkr.space:8081/artifactory/libs-snapshot") }

}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.2.0")
    implementation("com.vladsch.flexmark:flexmark:0.42.4")
    implementation("info.picocli:picocli:3.9.6")
    implementation(group = "no.tornado", name = "tornadofx", version = "1.7.19")
// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.5")

    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    testCompile("org.testfx:testfx-junit5:4.0.15-alpha")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testCompile(group= "org.junit.jupiter", name= "junit-jupiter-params", version= "5.4.2")

    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")


    // implementation(group="io.github.cottonmc", name="json-factory", version="0.5.0-beta.2-SNAPSHOT")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

apply(from = "jsonschema.gradle")