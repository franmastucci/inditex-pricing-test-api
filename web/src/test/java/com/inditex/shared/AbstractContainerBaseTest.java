package com.inditex.shared;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

/**
 * Base abstract class for containerized tests.
 */
public abstract class AbstractContainerBaseTest {

    /**
     * H2 database container for testing.
     */
    static final GenericContainer<?> H2_CONTAINER = new GenericContainer<>("h2:latest")
            .withExposedPorts(1521)
            .withEnv("H2_OPTIONS", "-ifNotExists")
            .waitingFor(Wait.forListeningPort())
            .withClasspathResourceMapping("data-test.sql", "/docker-entrypoint-initdb.d/data-test.sql", BindMode.READ_WRITE);

}
