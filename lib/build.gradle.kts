import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.dokka)
    `maven-publish`
    signing
}

version = "2.1.0"

android {
    namespace = "com.appliedrec.verid.common"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        testOptions.targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
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

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.appliedrec"
            artifactId = "verid3-common"
            afterEvaluate {
                from(components["release"])
            }

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
        }
    }

    repositories {
        maven {
            name = "MavenCentral"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = project.findProperty("mavenCentralUsername") as String?
                password = project.findProperty("mavenCentralPassword") as String?
            }
        }
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/AppliedRecognition/Ver-ID-Releases-Android")
            credentials {
                username = project.findProperty("gpr.user") as String?
                password = project.findProperty("gpr.token") as String?
            }
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications["release"])
}

tasks.withType<DokkaTask>().configureEach {
    moduleName.set("Ver-ID common types")
    moduleVersion.set(project.version.toString())
    outputDirectory.set(file("../docs"))
}