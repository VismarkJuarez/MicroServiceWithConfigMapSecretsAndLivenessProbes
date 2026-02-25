FROM eclipse-temurin:17-jdk
ADD target/DemoMicroservice-0.0.1-SNAPSHOT.jar DemoMicroservice.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DemoMicroservice.jar"]
# TODO:
# - What happens when we provide environment variable values here?
# - What if we COPY a configuration file, and that configuration file has dynamic variable placeholders? how do we pass those in?