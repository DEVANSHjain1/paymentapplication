load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-4.2",
    sha256 = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.2.zip",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.springframework.boot:spring-boot-starter-web:2.6.3",
        "org.springframework.boot:spring-boot-starter-data-mongodb:2.6.3",
        "org.springframework.kafka:spring-kafka:2.8.2",
        "io.temporal:temporal-sdk:1.24.1",
        "junit:junit:4.13.2",
        "org.mockito:mockito-core:3.+",
        "ch.qos.logback:logback-classic:1.2.10",
        "org.springframework.boot:spring-boot-starter-web:2.6.3",
        "org.springframework.boot:spring-boot-starter-data-mongodb:2.6.3",
        "org.springframework.kafka:spring-kafka:2.8.2",
        "io.temporal:temporal-sdk:1.24.1",
        "io.temporal:temporal-serviceclient:1.24.1",
        "io.temporal:temporal-sdk:1.17.0",
        "io.temporal:temporal-serviceclient:1.17.0",
        "org.springframework.boot:spring-boot-autoconfigure:2.6.3",
        "org.springframework.boot:spring-boot:2.6.3",
        "org.springframework:spring-context:5.3.15",
        "org.springframework:spring-beans:5.3.15",
        "org.apache.kafka:kafka-clients:3.0.0",
        "io.temporal:temporal-serviceclient:1.24.1",
        "org.springframework:spring-web:5.3.15",
        "org.springframework.data:spring-data-mongodb:3.3.1",
        "org.springframework.data:spring-data-commons:2.6.1",
        "org.springframework.boot:spring-boot-starter:2.6.3",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
