# FROM openjdk:11.0.13-jdk as builder

# COPY gradlew .
# COPY gradle gradle
# COPY build.gradle .
# COPY settings.gradle .
# COPY src src
# RUN chmod +x ./gradlew
# RUN ./gradlew bootJar 


# FROM openjdk:11.0.13-jdk

# #time
# ENV TZ=Asia/Seoul
# RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# COPY --from=builder build/libs/*.jar app.jar

# ENV PROFILE=local

# ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]

FROM gradle:7.3.2-jdk11 as builder

RUN gradle --version && java -version 
WORKDIR /app
COPY build.gradle settings.gradle /app/
RUN gradle clean build --no-daemon --exclude-task test > /dev/null 2>&1 || true
COPY ./ /app/
RUN gradle clean build --no-daemon --exclude-task test

# COPY gradlew .
# COPY gradle gradle
# COPY build.gradle .
# COPY settings.gradle .
# COPY src src
# RUN chmod +x ./gradlew
# RUN ./gradlew bootJar 


FROM openjdk:11.0.13-jdk

#time
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY --from=builder /app/build/libs/*.jar app.jar

ENV PROFILE=local

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]