package com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class KubernetesResourcesServiceTest {

    private static final Logger log = LoggerFactory.getLogger(KubernetesResourcesServiceTest.class);

    /***
     * TODO:
     *
     * For both of these, you need to Simply add a @SpringBootTest annotation to your test class,
     * and add @Autowired to the object (KubernetesResourcesService in this case)
     *
     * - [V] Learn how to inject test environment variables: you just need to pass the env var name as an argument and its value if running via the CLI. or if running with IntelliJ, go to "Run -> Edit Configurations", then modify the test configuration with a new environment variable name and value (VISMARKS_SECRET=TestSecretFromIntelliJ)
     * - [V] Learn how to utilize test config variables (application.properties for tests)
     *
     */

    // System under Test
    @Autowired
    private KubernetesResourcesService kubernetesResourcesService;

    @Test
    void retrieveConfigValuesAndSecret() {
        log.info(kubernetesResourcesService.retrieveConfigValuesAndSecret().toString());
        Assert.isTrue(true, "whatever is true");
    }
}