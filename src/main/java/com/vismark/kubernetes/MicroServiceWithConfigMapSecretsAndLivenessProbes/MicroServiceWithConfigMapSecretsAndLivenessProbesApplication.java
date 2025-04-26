package com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceWithConfigMapSecretsAndLivenessProbesApplication {

	private static final Logger log = LoggerFactory.getLogger(MicroServiceWithConfigMapSecretsAndLivenessProbesApplication.class);

	public static void main(String[] args) {

		log.info("The application has started!! This is simply a demo app used for experimenting" +
				"with Kubernetes ConfigMaps, Secrets, Liveness Probes and Readiness Probes.");

		SpringApplication.run(MicroServiceWithConfigMapSecretsAndLivenessProbesApplication.class, args);
	}

}
