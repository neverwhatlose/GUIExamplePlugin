plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ru.nwtls"
version = "1.0-dev"

repositories {
    mavenCentral()
    maven("https://repo.dmulloy2.net/repository/public/") //shadow gradle
    maven("https://repo.papermc.io/repository/maven-public/") //papermc
    maven("https://oss.sonatype.org/content/groups/public/") //cloud paper
}

dependencies {
    //papermc
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    //junit
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //slf4j
    implementation("org.slf4j:slf4j-api:${libs.versions.slf4j.get()}")
    implementation("org.slf4j:slf4j-simple:${libs.versions.slf4j.get()}")
    //cloud paper
    implementation("cloud.commandframework:cloud-paper:1.8.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "ru.nwtls.GUIExampleMain"
        )
    }
}

project.tasks.build {
    dependsOn(tasks.shadowJar)
}