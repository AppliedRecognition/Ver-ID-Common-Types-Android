@file:Suppress("UnstableApiUsage")

plugins {
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "ARCMavenCentral"
            val isSnapshot = version.toString().endsWith("SNAPSHOT")
            url = uri(
                if (isSnapshot)
                    "https://oss.sonatype.org/content/repositories/snapshots/"
                else
                    "https://ossrh-staging-api.central.sonatype.com/service/local/staging/deploy/maven2/"
            )
            credentials {
                // Prefer gradle.properties, fall back to env
                username = providers.gradleProperty("mavenCentralAccessTokenId")
                    .orElse(providers.environmentVariable("MAVEN_CENTRAL_TOKEN_ID"))
                    .orNull
                password = providers.gradleProperty("mavenCentralAccessToken")
                    .orElse(providers.environmentVariable("MAVEN_CENTRAL_TOKEN"))
                    .orNull
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