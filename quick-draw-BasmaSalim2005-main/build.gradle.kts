import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id(libs.plugins.kotlin.jvm.get().pluginId) version libs.versions.jvm.get()
    alias(libs.plugins.detekt)
    alias(libs.plugins.mosaic)
}

val jdkVersion = libs.versions.jdk.get()

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.std)
    implementation(libs.mosaic)
    detektPlugins(libs.detekt.formatting)
    implementation(libs.jline)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlin.test.exit)
    testImplementation(libs.junit.params)
    testImplementation(libs.mockito)
}

tasks {
    withType<Detekt>().configureEach {
        jvmTarget = jdkVersion
    }

    jar {
        manifest.attributes["Main-Class"] = "org.example.MainKt"
        val dependencies = configurations
            .runtimeClasspath
            .get()
            .map(::zipTree)
        from(dependencies)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(17)
}
