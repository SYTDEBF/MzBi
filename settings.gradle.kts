pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url = uri("https://maven.aliyun.com/repositories/jcenter") }
        maven { url = uri("https://maven.aliyun.com/repositories/google") }
        maven { url = uri("https://maven.aliyun.com/repositories/central") }


    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven{url= uri("https://jitpack.io")}
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        maven { url = uri("https://maven.aliyun.com/repositories/jcenter") }
        maven { url = uri("https://maven.aliyun.com/repositories/google") }
        maven { url = uri("https://maven.aliyun.com/repositories/central") }

    }
}

rootProject.name = "MzBi"
include(":app")
 