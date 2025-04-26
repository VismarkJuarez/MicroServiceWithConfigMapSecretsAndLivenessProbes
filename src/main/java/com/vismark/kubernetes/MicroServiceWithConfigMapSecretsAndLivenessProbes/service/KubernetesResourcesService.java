package com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KubernetesResourcesService {

    @Value("${application.firstName}") // Value is expected from the application.properties file. On Kubernetes, it'll be read in from a ConfigMap
    private String firstName;

    @Value("${application.lastName}") // Value is expected from the application.properties file. On Kubernetes, it'll be read in from a ConfigMap
    private String lastName;

    @Value("${application.age}") // Value is expected from the application.properties file. On Kubernetes, it'll be read in from a ConfigMap
    private int age;

    @Value("${VISMARKS_SECRET}") // Value is expected to be an environment variable. On Kubernetes, this will be specified in a Secret
    private String vismarksSecret;

    public KubernetesResourcesService(){
        // Default constructor. Without it, Spring cannot create a Bean.
    }

    public Map<String, String> retrieveConfigValuesAndSecret(){
        Map<String, String> configValuesAndSecret = new HashMap<>();
        configValuesAndSecret.put("[configuration property] firstName", firstName);
        configValuesAndSecret.put("[configuration property] lastName", lastName);
        configValuesAndSecret.put("[configuration property] age", String.valueOf(age)); // converted to a String to keep things simple
        configValuesAndSecret.put("[environment variable] vismarksSecret", vismarksSecret);
        return configValuesAndSecret;
    }

}