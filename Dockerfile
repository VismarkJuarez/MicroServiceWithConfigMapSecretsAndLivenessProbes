FROM openjdk:17
ADD target/MicroServiceWithConfigMapSecretsAndLivenessProbes-0.0.1-SNAPSHOT.jar MicroServiceWithConfigMapSecretsAndLivenessProbes.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "MicroServiceWithConfigMapSecretsAndLivenessProbes.jar"]
# TODO:
# - What happens when we provide environment variable values here?
# - What if we COPY a configuration file, and that configuration file has dynamic variable placeholders? how do we pass those in?
# - change the port, and see how the deployment/service/Pod definitions need to change