plugins {
    java
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.sonarqube") version "6.0.1.5171"
    jacoco
    checkstyle
}

group = "com"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


tasks.jacocoTestReport {
    reports {
        xml.required = true
        csv.required = false
    }
}

checkstyle {
    configFile = file("${rootDir}/naver-checkstyle-rules.xml")
    configProperties["suppressionFile"] = "${rootDir}/naver-checkstyle-suppressions.xml"
    toolVersion = "9.2"
}


sonar {
    properties {
        property("sonar.projectKey", "sapiens2000-dev_simple-sns")
        property("sonar.organization", "sapiens2000-dev")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
        property("sonar.java.checkstyle.reportPaths", "build/reports/checkstyle/main.xml")
    }
}
