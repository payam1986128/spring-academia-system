package ir.payam1986128.examples.springacademiasystem.application;

import io.restassured.RestAssured;
import ir.payam1986128.examples.springacademiasystem.contract.enumeration.Role;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.AuthRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.OfferCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.StudentCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserRequest;
import jakarta.annotation.PostConstruct;
import org.instancio.Instancio;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.instancio.Select.allStrings;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcademiaApplicationTests {
    private String token;
    private UUID courseId;
    private UUID lecturerId;
    private UUID offerId;
    private final int offerCapacity = 10;
    private final int concurrentUsers = 20;
    private final Queue<String> studentNumbers = new ConcurrentLinkedQueue<>();
    private final Queue<String> studentTokens = new ConcurrentLinkedQueue<>();

    @LocalServerPort
    public int serverPort;

    @PostConstruct
    public void initRestAssured() {
        RestAssured.port = serverPort;
    }

    @Test
    @Order(0)
    void givenAnAdminUser_whenLoginUser_thenResponseStatusIsOk() throws Exception {

        AuthRequest request = new AuthRequest();
        request.setUsername("admin");
        request.setPassword("admin");

        token = RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .when()
                .with()
                .body(request)
                .post("/api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @Test
    @Order(1)
    void givenAnEducationFacultyUser_whenRegisterUser_thenResponseStatusIsCreated() throws Exception {

        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("edu1");
        request.setPassword("edu1");
        request.setRole(Role.FACULTY_EDUCATION_OFFICE);

        RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .when()
                .with()
                .body(request)
                .post("/api/auth/users")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(2)
    void givenAnEducationFacultyUser_whenLoginUser_thenResponseStatusIsOk() throws Exception {

        AuthRequest request = new AuthRequest();
        request.setUsername("edu1");
        request.setPassword("edu1");

        token = RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .when()
                .with()
                .body(request)
                .post("/api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @Test
    @Order(3)
    void givenASemesterData_whenCreateSemester_thenResponseStatusIsCreated() throws Exception {
        SemesterCreationRequest request = new SemesterCreationRequest();
        request.setTitle("2025-2");
        request.setStartDate(LocalDate.now().minusMonths(3));
        request.setEndDate(LocalDate.now().plusMonths(3));

        RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .when()
                .with()
                .body(request)
                .post("/api/semesters")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(4)
    void givenACourseData_whenCreateCourse_thenResponseStatusIsCreated() throws Exception {
        CourseCreationRequest request = new CourseCreationRequest();
        request.setName("ANN");
        request.setUnits(4);

        courseId = RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .when()
                .with()
                .body(request)
                .post("/api/courses")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
    }

    @Test
    @Order(5)
    void givenALecturerData_whenCreateLecturer_thenResponseStatusIsCreated() throws Exception {
        LecturerCreationRequest request = new LecturerCreationRequest();
        request.setFirstName("Ali");
        request.setLastName("Alavi");

        lecturerId = RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .when()
                .with()
                .body(request)
                .post("/api/lecturers")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
    }

    @Test
    @Order(6)
    void givenAnOfferData_whenCreateOffer_thenResponseStatusIsCreated() throws Exception {
        OfferCreationRequest request = new OfferCreationRequest();
        request.setTitle("ANN-2025");
        request.setLecturerId(lecturerId.toString());
        request.setCourseId(courseId.toString());
        request.setCapacity(offerCapacity);

        offerId = RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .when()
                .with()
                .body(request)
                .post("/api/offers")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
    }

    @Test
    @Order(7)
    void givenAStudentData_whenCreateStudent_thenResponseStatusIsCreated() throws Exception {
        List<Callable<String>> tasks = Stream.generate(
                () -> (Callable<String>) () -> {
                    StudentCreationRequest request = new StudentCreationRequest();
                    request.setFirstName(
                            Instancio.of(String.class)
                            .generate(allStrings(), gen -> gen.string().length(10))
                            .create()
                    );
                    request.setLastName(
                            Instancio.of(String.class)
                            .generate(allStrings(), gen -> gen.string().length(10))
                            .create()
                    );

                    return RestAssured.given()
                            .contentType(APPLICATION_JSON_VALUE)
                            .accept(APPLICATION_JSON_VALUE)
                            .header("Authorization", "Bearer " + token)
                            .when()
                            .with()
                            .body(request)
                            .post("/api/students")
                            .then()
                            .statusCode(201)
                            .extract()
                            .path("studentNumber");
                }).limit(concurrentUsers).toList();

        try (ExecutorService executorService = Executors.newFixedThreadPool(concurrentUsers)) {
            List<Future<String>> results = executorService.invokeAll(tasks);
            results.forEach(f -> {
                try {
                    studentNumbers.offer(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            assertThat(studentNumbers.size()).isEqualTo(concurrentUsers);
        }
    }

    @Test
    @Order(8)
    void givenAStudentUser_whenRegisterUser_thenResponseStatusIsCreated() throws Exception {
        AtomicInteger userIndex = new AtomicInteger(0);
        List<Callable<Integer>> tasks = Stream.generate(
                () -> (Callable<Integer>) () -> {
                    CreateUserRequest request = new CreateUserRequest();
                    request.setUsername("stu"+userIndex.incrementAndGet());
                    request.setPassword("stu"+userIndex.incrementAndGet());
                    request.setRole(Role.STUDENT);
                    request.setStudentNumber(studentNumbers.poll());

                    return RestAssured.given()
                            .contentType(APPLICATION_JSON_VALUE)
                            .accept(APPLICATION_JSON_VALUE)
                            .when()
                            .with()
                            .body(request)
                            .post("/api/auth/users")
                            .then()
                            .extract()
                            .statusCode();
                }).limit(concurrentUsers).toList();

        try (ExecutorService executorService = Executors.newFixedThreadPool(concurrentUsers)) {
            List<Future<Integer>> results = executorService.invokeAll(tasks);
            List<Integer> statuses = results.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).toList();
            assertThat(statuses.size()).isEqualTo(concurrentUsers);
        }
    }

    @Test
    @Order(9)
    void givenAStudentUser_whenLoginUser_thenResponseStatusIsOk() throws Exception {
        AtomicInteger userIndex = new AtomicInteger(0);
        List<Callable<String>> tasks = Stream.generate(
                () -> (Callable<String>) () -> {
                    AuthRequest request = new AuthRequest();
                    request.setUsername("stu"+userIndex.incrementAndGet());
                    request.setPassword("stu"+userIndex.incrementAndGet());

                    return RestAssured.given()
                            .contentType(APPLICATION_JSON_VALUE)
                            .accept(APPLICATION_JSON_VALUE)
                            .when()
                            .with()
                            .body(request)
                            .post("/api/auth/login")
                            .then()
                            .statusCode(200)
                            .extract()
                            .path("accessToken");
                }).limit(concurrentUsers).toList();

        try (ExecutorService executorService = Executors.newFixedThreadPool(concurrentUsers)) {
            List<Future<String>> results = executorService.invokeAll(tasks);
            results.forEach(f -> {
                try {
                    studentTokens.offer(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            assertThat(studentTokens.size()).isEqualTo(concurrentUsers);
        }
    }

    @Test
    @Order(10)
    void givenCalledMuchTimesAtOnce_whenRegisterEnrollment_thenOfferCapacityExceeded() throws Exception {
        List<Callable<Integer>> tasks = Stream.generate(
                () -> (Callable<Integer>) () -> RestAssured
                        .given()
                        .contentType(APPLICATION_JSON_VALUE)
                        .accept(APPLICATION_JSON_VALUE)
                        .header("Authorization", "Bearer " + studentTokens.poll())
                        .when()
                        .post("/api/offers/"+offerId+"/enrollments")
                        .then()
                        .extract()
                        .statusCode()
        ).limit(concurrentUsers).toList();

        try (ExecutorService executorService = Executors.newFixedThreadPool(concurrentUsers)) {
            List<Future<Integer>> results = executorService.invokeAll(tasks);
            List<Integer> statuses = results.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).toList();
            assertThat(statuses.stream().filter(s -> s == 201).count()).isEqualTo(offerCapacity);
        }
    }
}
