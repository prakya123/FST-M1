package githubTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GitHubAPITest {

    RequestSpecification requestSpec;

    // Your actual SSH PUBLIC key (safe to share)
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJv7fbzTiTuSNogYJLPul+gg5OpbiyllfTkEn+KX8Bxp azuread\\yprakyathi@IN002BWI";

    int keyId;   // GitHub will return this ID


    // -------------------------------
    // SETUP BEFORE ALL TESTS
    // -------------------------------
    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "ccbbcbxvcbvxcxb") // 
                .build();
    }


    // -------------------------------
    // 1. POST → Add SSH Key
    // -------------------------------
    @Test(priority = 1)
    public void addSSHKey() {

        String body = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                given()
                        .spec(requestSpec)
                        .body(body)
                .when()
                        .post("/user/keys");

        response.then().log().all();

        keyId = response.jsonPath().getInt("id");

        Assert.assertEquals(response.statusCode(), 201, "POST request failed!");
        Assert.assertTrue(keyId > 0, "Key ID not returned!");
    }


    // -------------------------------
    // 2. GET → Retrieve SSH Key
    // -------------------------------
    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                .when()
                        .get("/user/keys/{keyId}");

        Reporter.log(response.asString(), true);

        Assert.assertEquals(response.statusCode(), 200, "GET request failed!");
        Assert.assertEquals((int) response.jsonPath().get("id"), keyId);
    }


    // -------------------------------
    // 3. DELETE → Remove SSH Key
    // -------------------------------
    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                .when()
                        .delete("/user/keys/{keyId}");

        Reporter.log("DELETE Status Code: " + response.statusCode(), true);

        Assert.assertEquals(response.statusCode(), 204, "DELETE request failed!");
    }
}
