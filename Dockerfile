FROM maven:3.6-openjdk-16

# Add the service itself
COPY ./target/common-survey-export.jar /usr/share/app/

ENTRYPOINT ["java", "-jar", "/usr/share/app/common-survey-export.jar"]