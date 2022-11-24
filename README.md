# RestAPI User With Spring Boot
Basic Rest API with Spring Boot using Spring Data JPA, H2, and Swagger-UI

1. Rest API User
2. Steps to run the application
3. API document

---

# 1. Rest API User

> Rest API that allows creating, updating, deleting, and getting users. 

It is built with the following technology:
     • IntelliJ IDEA
     • Springboot v2.4.3
     • H2 Database
     • Spring Data JPA
     • Swagger-UI
     
# 2. Steps to run the application

> Open H2 console

      > http://localhost:8080/h2-console      
        
      > in the application.properties file are the username and password

![alt text](https://github.com/glorycaridad91/RestAPIUserWithSpringBoot/blob/feature/APIRestUser/src/main/resources/H2%20database.png) 

> Build and Run the application

    > run the main method from CursoSpringbootApplication.java as a Spring boot application


# 3. For API document

> Using Postman (or any RESTful API testing tool) or API document using OpenAPI 3.0

    Postman
       >http://localhost:8080/api/v1/users

    OpenAPI 3.0
       > http://localhost:8080/swagger-ui.html

![alt text](https://github.com/glorycaridad91/RestAPIUserWithSpringBoot/blob/feature/APIRestUser/src/main/resources/endpoints.png)

