package API_Test_Functionality;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.io.IOUtils;
import org.hamcrest.core.Is;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UsersAPI {

    public static String dir = System.getProperty("user.dir");
    FileInputStream body_json = new FileInputStream(new File(dir + "\\src\\main\\java\\Test_Data\\Data.json"));

    public UsersAPI() throws FileNotFoundException {
    }

    public void getStatusCode_For_Services() throws IOException {
        String url = "https://apim-hl-life-uat-za.azure-api.net/Application/v1/Application";
        given()
                .header("x-subscription-id", "Life-Integration-Team")
                .header("Ocp-Apim-Subscription-Key", "82ee9d316d7e4e8dbba3d71c9d0d4027")
                .header("Content-Type", "application/json")
                .body(IOUtils.toString(body_json, "UTF-8"))
                .post(url)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void logBodyContent() throws IOException {
        String url = "https://apim-hl-life-uat-za.azure-api.net/Application/v1/Application";
        given()
                .header("x-subscription-id", "Life-Integration-Team")
                .header("Ocp-Apim-Subscription-Key", "82ee9d316d7e4e8dbba3d71c9d0d4027")
                .header("Content-Type", "application/json")
                .body(IOUtils.toString(body_json, "UTF-8"))
                .post(url)
                .then()
                .log()
                .body();
    }

    public void Post_User_And_Verify_Response1() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users";
        given()
                .post(url)
                .then().assertThat().body("application.sourceReference", Is.is("T01"));
    }

    public void Post_User_And_Verify_Response() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users";
        given()
                .header("Content-Type", "application/json")
                .post(url)
                .then()
                .assertThat().body("id", Is.is(11));
    }

    public void Get_Single_User_And_Verify() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users/1";
        given()
                .header("Content-Type", "application/json")
                .get(url)
                .then()
                .assertThat().body("username", Is.is("Bret"));
    }

    public void Get_Ten_Users_And_Verify() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/users/1";
        given()
                .header("Content-Type", "application/json")
                .get(url)
                .then()
                .assertThat()
                .body("bar.size",Is.is(1));
    }

    public void GetTen()
    {
        String url = "https://jsonplaceholder.typicode.com/users";
        given().
                header("Content-Type", "application/json").
                get(url).
                then().
                assertThat().
                body("list.size()", Is.is(10));
    }
}