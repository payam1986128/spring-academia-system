# Academia Course Selection System

### Run the application:<br/>
0. Install and configure postgre db
1. Set connection string in project application.yml
2. $ `mvn clean package`
3. $ java -jar application-{version}.jar
4. Or can use below command:<br/>
   $ `docker compose run`

#### note: Please run `mvn clean package` before run or debug application to generate querydsl and mapstruct essential sources 

### Test with postman:<br/>
Import postman collection file in the root of project to the postman GUI.<br/>
The access token would be set after calling login service.<br/>
Then you can call the other service without setting access token in Authorization header.


### Frameworks and used libraries:<br/>
1. Java 21
2. Spring boot v3.5.5
3. Spring web starter: to prepare REST services
4. Spring security starter: to prepare authentication and authorization
5. Spring data JPA starter: to use Hibernate ORM
6. Spring validation starter: to validate request data
7. Spring test starter: to integrate tests
8. Rest assured: to assert service responses
9. Lombok: to reduce boilerplate of POJOs
10. Mapstruct: to map objects to each other
11. QueryDsl: to prepare dynamic query
12. JWT: to configure bearer token auth type
13. Maven: to build modules and project
14. Docker: to build project in the container
15. Docker compose: to build and initialize services in the container based environment
16. postgresql: to query and command data


### Architecture:<br/>
The architecture of this project is according to **Clean Architecture** to using benefits of Onion design.<br/>
This design help isolating and hiding entities and their relationships implementation from outside clients.<br/>
Two notes to consider is that:<br/>
1. Dependency of **business** and **persistence** modules are inversed to prevent entities from being used in business module.
2. Dependency of persistence objects are injected by Spring container to business module.

### Scenario:<br/>
note: pre defined admin user info:<br/>
username: admin<br/>
password: admin
1. Create another user with role FACULTY_EDUCATION_OFFICE
2. Login with that just been created user of faculty education office
3. Create a semester with start date before now and it's end date after now
4. Create a course
5. Create a lecturer
6. Create an offer with these course and lecturer (current semester is automatically will be used for this offer)
7. Create a student
8. Create a user for that student
9. Login with that user of student
10. Create an enrollment for that student with just been created offer