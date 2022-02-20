buildscript {

    repositories {
        google()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
        maven ( url ="https://oss.sonatype.org/content/repositories/snapshots/" )
        maven ( url = "https://oss.jfrog.org/libs-snapshot" )
    }


    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
        classpath("com.android.tools.build:gradle:7.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40")
        classpath ("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.6.10-1.0.3")

    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.



task("clean", Delete::class) {
    delete(rootProject.buildDir)
}