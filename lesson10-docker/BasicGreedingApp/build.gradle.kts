plugins {
    id("java")
}

group = "org.cs489"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar{
//    archiveBaseName.set("myapp")
    archiveBaseName = "myapp"
    archiveVersion = "1.0.1"
    manifest{
        attributes["Main-Class"] = "org.cs489.Main"
    }
}