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
    private final String fileNameEnvironmentVariable;
    private final String filePathEnvironmentVariable; // holds a file path to a file for reading

    // Spring automatically injects these parameters from your properties/env vars
    // Default values for both the app config variables, and the environment variable
    // have been specified.
    public KubernetesResourcesService(
            @Value("${application.firstName:John}") String firstName,
            @Value("${application.lastName:Doe}") String lastName,
            @Value("${application.age:30}") int age,
            @Value("${MY_ENVIRONMENT_VARIABLE:default_filename.txt}") String fileNameEnvironmentVariable,
            @Value("${FILE_PATH_ENVIRONMENT_VARIABLE:/Users/vismarkjuarez/default/file/path}") String filePathEnvironmentVariable) { // use "./src/main/resources" if you intend for the file to be located in the project itself. by default, variable will look for the file at the absolute path specified here.
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fileNameEnvironmentVariable = fileNameEnvironmentVariable;
        this.filePathEnvironmentVariable = filePathEnvironmentVariable;
    }

    public Map<String, String> retrieveConfigValuesAndSecret() {
        Map<String, String> configValuesAndSecret = new HashMap<>();
        configValuesAndSecret.put("[configuration property] firstName", firstName);
        configValuesAndSecret.put("[configuration property] lastName", lastName);
        configValuesAndSecret.put("[configuration property] age", String.valueOf(age));
        configValuesAndSecret.put("[environment variable] fileNameEnvironmentVariable", fileNameEnvironmentVariable);
        configValuesAndSecret.put("[environment variable] filePathEnvironmentVariable", filePathEnvironmentVariable);
        configValuesAndSecret.put("[file content] fileContent", readFileContent(filePathEnvironmentVariable, fileNameEnvironmentVariable));

        return configValuesAndSecret;
    }

    private String readFileContent(String filePath, String fileName) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(filePath, fileName);
            return java.nio.file.Files.readString(path);
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}