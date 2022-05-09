plugins {
    id ("org.springframework.boot") version "2.6.6"
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
    implementation ("org.springdoc:springdoc-openapi-ui:1.6.4")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    runtimeOnly("com.h2database:h2")
}

tasks.withType<Test>() {
    useJUnitPlatform()
}


