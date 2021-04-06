package junit;
import TestBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstSenerityApp extends TestBase {
    @Test
    public void getAllStudent() {
       SerenityRest.given().when().get().then().statusCode(200);

    }
    @Test
    public void thisFaillingTest(){
        SerenityRest.given().when().get("/list").then().statusCode(500);
    }
    @Pending
    @Test
    public void thisPendingTest(){
        SerenityRest.given().when().get("/list").then().statusCode(500);
    }
    @Ignore
    @Test
    public void thisSkipTest(){
        SerenityRest.given().when().get("/list").then().statusCode(500);
    }
}
