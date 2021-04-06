package SerenitySteps;

import Model.StudentClass;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.junit.annotations.Concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Concurrent
public class StudentSerenitySteps {
    @Step
    public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, List<String> course) {
        StudentClass studentList = new StudentClass();
        studentList.setFirstName(firstName);
        studentList.setLastName(lastName);
        studentList.setEmail(email);
        studentList.setProgramme(programme);
        studentList.setCourse(course);
        return SerenityRest.rest().given()
                .contentType(ContentType.JSON).
                        log().all().when().body(studentList)
                .post().then();
    }
    @Step
    public HashMap<String,Object> getStudentInforByFirstName(String firstName){
        String path1 = "findAll{it.firstName=='";
        String path2="'}.get(0)";

        return SerenityRest.rest().given().when().get("/list").then()
                .extract()
                .path(path1+firstName+path2);
    }
}
