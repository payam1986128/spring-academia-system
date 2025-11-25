# Academia Course Selection System

### Run the application:<br/>
0. Install and configure postgre db
1. Set connection string in project application.yml
2. `mvn clean package`. This command should be run to generate querydsl and mapstruct essential sources also besides build the jar file
3. `java -jar application-{version}.jar`
4. Or use below command:<br/>
   `docker compose run`

### Test with postman:<br/>
Import postman collection file in the root of project into the postman GUI.<br/>
The access token and the other required params would be set after calling each services.<br/>
For example you can call the other services without setting access token in Authorization header.


### Frameworks and used libraries:<br/>
1. Java 21
2. Spring boot v3.5.5
3. Spring web starter: to prepare REST services
4. Spring security starter: to prepare authentication and authorization
5. Spring data JPA starter: to use an ORM such as Hibernate
6. Spring validation starter: to validate request data
7. Spring test starter: to integrate tests
8. Rest assured: to assert service responses
9. Lombok: to reduce boilerplate of classes
10. Mapstruct: to map objects to each other
11. QueryDsl: to prepare dynamic query
12. JWT: to configure bearer token auth type
13. Maven: to build modules and project
14. Docker: to build project in the container
15. Docker compose: to build and initialize services in the container based environment
16. Postgresql: to query and command data
17. Spring retry: to retry logics that fails
18. Instancio: to create given data randomly just for tests
19. Springdoc openapi: to create api docs in swagger ui. The doc would be found here: http://localhost:8080/swagger-ui/index.html
20. JUnit and Mockito: to provide unit tests


### Architecture:<br/>
The architecture of this project is according to **Clean Architecture** to using benefits of Onion design.<br/>
This design help isolating and hiding entities and their relationships implementation from outside clients.<br/>
Two notes to consider is that:<br/>
1. Dependency of **business** and **persistence** modules are inversed to prevent entities from being used in business module.
2. Dependency of persistence objects are injected by Spring container to business module.

<br/>![Screenshot Clean Architecture](https://i.sstatic.net/CeRYR.jpg)

### Modules
This system has these 5 modules:
1. persistence: It includes entities and spring data repositories and is the same as 'Entities' in the above image.
2. contract: It contains of objects that transfer between layers and also the API of data access objects (dao) and services. This module locates in the Interface Adapters in the above image.
3. business: There are all business logics here. It is the same as 'Use Cases'.
4. presentation: All rest endpoints are here to communicate to clients. It is the same as 'Controllers' that it depends on 'contract'.
5. application: The spring application context is configured here. and that the same as 'Frameworks' in the above image. The responsability of this module is injecting dependencies according their interfaces.


### Test Scenario:<br/>
Pre-defined admin user info:<br/>
username: admin<br/>
password: admin
0. Login with admin user. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L50)
1. Create another user with role FACULTY_EDUCATION_OFFICE. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L71)
2. Login with that just been created user of faculty education office. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L92)
3. Create a semester with start date before now and it's end date after now. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L113)
4. Create a course. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L133)
5. Create a lecturer. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L154)
6. Create an offer with these course and lecturer (current semester is automatically will be used for this offer). [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L175)
7. Create n students (n > 0). [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L198)
8. Create n user for those students. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L242)
9. Login with those users of students. [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L279)
10. Create m enrollments for those students with just been created offers (m > n). [See here](https://github.com/payam1986128/spring-academia-system/blob/master/application/src/test/java/ir/payam1986128/examples/springacademiasystem/application/AcademiaApplicationTests.java#L315)
11. Then n enrollments should be registered and m-n ones should be rejected.

<br/>This project has also unit tests in [here](https://github.com/payam1986128/spring-academia-system/tree/master/business/src/test/java/ir/payam1986128/examples/springacademiasystem/business/service)