package junit;

import Model.StudentClass;
import SerenitySteps.StudentSerenitySteps;
import TestBase.TestBase;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SerenityRunner.class)
public class CRUDStudent extends TestBase {
    @Steps
    StudentSerenitySteps steps;
    @Test
    public void insertStudent() {
        Faker fakeData = new Faker();
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C#");
        String firstName= fakeData.name().firstName();
        String lastName = fakeData.name().lastName();
        String email = fakeData.internet().emailAddress();
        String programme = fakeData.educator().course();
        steps.createStudent(firstName,lastName,email,programme,courses).statusCode(201);
        HashMap<String,Object> value = steps.getStudentInforByFirstName(firstName);
        System.out.println(value);
    }

}
