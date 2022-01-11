FROM azul/zulu-openjdk:16

# Add the service itself
COPY ./target/common-survey-export.jar /usr/share/app/

RUN apt-get update && apt-get upgrade -y

ENTRYPOINT ["java", "-jar", "/usr/share/app/common-survey-export.jar"]