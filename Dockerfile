FROM openjdk:11.0.13-jdk as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar 


FROM openjdk:11.0.13-jdk

#time
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder build/libs/*.jar app.jar

ENV PROFILE=local

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]


# FROM openjdk:11.0.13-jdk as dependency

# WORKDIR /workspace/app
# COPY gradlew .
# COPY gradle gradle
# COPY build.gradle .
# COPY settings.gradle .
# # COPY src src
# RUN chmod +x ./gradlew
# RUN ./gradlew buildDependents -DskipTests

# FROM openjdk:11.0.13-jdk as builder
# WORKDIR /workspace/app

# COPY --from=dependency /root/.m2/ /root/.m2/
# COPY gradlew .
# COPY gradle gradle
# COPY build.gradle .
# COPY settings.gradle .
# COPY src src
# RUN ./gradlew bootJar -DskipTests

# FROM openjdk:11.0.13-jdk
# #time
# ENV TZ=Asia/Seoul
# RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# COPY --from=builder build/libs/*.jar app.jar

# ENV PROFILE=local

# ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]