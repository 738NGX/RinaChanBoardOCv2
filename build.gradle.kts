// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven { url=uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url=uri("https://maven.aliyun.com/repository/google") }
        maven { url=uri("https://maven.aliyun.com/repository/public") }
        maven { url=uri("https://maven.aliyun.com/repository/jcenter") }
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}