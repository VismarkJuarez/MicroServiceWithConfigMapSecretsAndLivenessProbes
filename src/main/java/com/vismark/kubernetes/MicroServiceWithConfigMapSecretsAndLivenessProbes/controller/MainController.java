package com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes.controller;

import com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes.service.KubernetesResourcesService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    private final KubernetesResourcesService kubernetesResourcesService;

    public MainController(KubernetesResourcesService kubernetesResourcesService){
        this.kubernetesResourcesService = kubernetesResourcesService;
    }

    @GetMapping("/configs")
    ResponseEntity<Map<String, String>> retrieveKubernetesProperties(){
        Map<String, String> kubernetesConfigValuesAndSecret = kubernetesResourcesService.retrieveConfigValuesAndSecret();
        return new ResponseEntity<Map<String, String>>(kubernetesConfigValuesAndSecret, HttpStatusCode.valueOf(200));
    }
}
