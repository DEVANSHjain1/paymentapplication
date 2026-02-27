java_library(
    name = "bank-lib",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = [
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        "@maven//:org_springframework_boot_spring_boot_starter_data_mongodb",
        "@maven//:org_springframework_kafka_spring_kafka",
        "@maven//:io_temporal_temporal_sdk",
        "@maven//:io_temporal_temporal_serviceclient",
    ],
)

java_binary(
    name = "BankProcess",
    srcs = glob(["src/main/java/**/*.java"]),
    main_class = "main.java.com.example.BankProcess",
    deps = [
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        "@maven//:org_springframework_boot_spring_boot_starter_data_mongodb",
        "@maven//:org_springframework_kafka_spring_kafka",
        "@maven//:io_temporal_temporal_sdk",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_spring_context",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_apache_kafka_kafka_clients",
        "@maven//:io_temporal_temporal_serviceclient",
        "@maven//:org_springframework_spring_web",
        "@maven//:org_springframework_data_spring_data_mongodb",
        "@maven//:org_springframework_data_spring_data_commons",
        "@maven//:org_springframework_boot_spring_boot_starter",
    ],
)

java_test(
    name = "BankProcessTest",
    srcs = ["src/test/java/com/example/controller/BankControllerTest.java"],
    test_class = "com.example.controller.BankControllerTest",
    deps = [
        ":BankProcess",
        "@maven//:junit_junit",
        "@maven//:org_mockito_mockito_core",
        "@maven//:org_springframework_spring_web",
    ],
    runtime_deps = [
            "@maven//:ch_qos_logback_logback_classic",
    ],
)