# springboot demo

### 참고한 사이트
- https://goddaehee.tistory.com/238
- https://start.spring.io/
  - Project: Gradle Project
  - Language: Java
  - Spring Boot: 2.7.0(SNAPSHOT)
  - Packaging: Jar
  - Java: 11
  - Dependencies
    - Spring Boot DevTools
    - Lombok
    - Spring Web

### docker image
`docker build -t springboot-demo .`
`docker run -p 8080:8080 springboot-demo`

###### 로컬환경에서 http://localhost:8080/