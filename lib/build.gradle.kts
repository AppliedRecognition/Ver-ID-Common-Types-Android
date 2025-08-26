import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.dokka)
    alias(libs.plugins.vanniktechPublish)
    signing
}

version = "3.1.0"

android {
    namespace = "com.appliedrec.verid.common"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        testOptions.targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}

mavenPublishing {
    coordinates("com.appliedrec", "verid-common", "3.0.0")
    pom {
        name.set("Ver-ID Common Types")
        description.set("Types used by Ver-ID SDK modules")
        url.set("https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android")
        licenses {
            license {
                name.set("Commercial")
                url.set("https://raw.githubusercontent.com/AppliedRecognition/Ver-ID-Common-Types-Android/refs/heads/main/LICENCE.txt")
            }
        }
        developers {
            developer {
                id.set("appliedrec")
                name.set("Applied Recognition")
                email.set("support@appliedrecognition.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/AppliedRecognition/Ver-ID-Common-Types-Android.git")
            developerConnection.set("scm:git:ssh://github.com/AppliedRecognition/Ver-ID-Common-Types-Android.git")
            url.set("https://github.com/AppliedRecognition/Ver-ID-Common-Types-Android")
        }
    }
    publishToMavenCentral(automaticRelease = true)
}

tasks.withType<DokkaTask>().configureEach {
    moduleName.set("Ver-ID common types")
    moduleVersion.set(project.version.toString())
    outputDirectory.set(file("../docs"))
}