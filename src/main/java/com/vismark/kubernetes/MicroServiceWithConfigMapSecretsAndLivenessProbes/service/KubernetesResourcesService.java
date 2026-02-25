package com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KubernetesResourcesService {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String myEnvironmentVariable;

    // Spring automatically injects these parameters from your properties/env vars
    // Default values for both the app config variables, and the environment variable
    // have been specified.
    public KubernetesResourcesService(
            @Value("${application.firstName:John}") String firstName,
            @Value("${application.lastName:Doe}") String lastName,
            @Value("${application.age:30}") int age,
            @Value("${MY_ENVIRONMENT_VARIABLE:default_environment_variable}") String myEnvironmentVariable) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.myEnvironmentVariable = myEnvironmentVariable;
    }

    public Map<String, String> retrieveConfigValuesAndSecret() {
        Map<String, String> configValuesAndSecret = new HashMap<>();
        configValuesAndSecret.put("[configuration property] firstName", firstName);
        configValuesAndSecret.put("[configuration property] lastName", lastName);
        configValuesAndSecret.put("[configuration property] age", String.valueOf(age));
        configValuesAndSecret.put("[environment variable] myEnvironmentVariable", myEnvironmentVariable);
        return configValuesAndSecret;
    }
}