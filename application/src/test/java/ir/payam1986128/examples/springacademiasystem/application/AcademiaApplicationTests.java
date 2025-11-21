package ir.payam1986128.examples.springacademiasystem.application;

import io.restassured.RestAssured;
import ir.payam1986128.examples.springacademiasystem.contract.enumeration.Role;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserRequest;
import jakarta.annotation.PostConstruct;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcademiaApplicationTests {

    @LocalServerPort
    public int serverPort;

    @PostConstruct
    public void initRestAssured() {
        RestAssured.port = serverPort;
    }

    @Test
    void givenUserData_whenCreateUser_thenSuccess() {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("admin");
        request.setPassword("password");
        request.setRole(Role.FACULTY_EDUCATION_OFFICE);

        RestAssured
                .given()
                    .contentType(APPLICATION_JSON_VALUE)
                    .accept(APPLICATION_JSON_VALUE)
                .when()
                    .with().body(request)
                    .post("/api/auth/users")
                .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("id", Matchers.notNullValue());
    }

    @Test
    void givenGetStudents_whenNotProvidedAccessToken_thenUnauthorised() {
        RestAssured
                .given()
                    .accept(APPLICATION_JSON_VALUE)
                .when()
                    .get("/api/students")
                .then()
                    .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}
