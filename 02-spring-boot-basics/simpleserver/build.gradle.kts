plugins {
    id ("org.springframework.boot") version "2.6.7"
    id ("io.spring.dependency-management" )version "1.0.11.RELEASE"
    id ("java")
    id("io.freefair.lombok") version "6.4.3"
}

group = "com.scaler"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test>() {
    useJUnitPlatform()
}
