package githubTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubAPITest {

    RequestSpecification requestSpec;
    String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAg....";  // your SSH key
    int keyId;  // GitHub SSH key ID will be stored here

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization", "token <YOUR_GITHUB_TOKEN>")
                .setContentType(ContentType.JSON)
                .build();
    }

    // -------------------------
    // 1. POST: Add SSH Key
    // -------------------------
    @Test(priority = 1)
    public void addSSHKey() {
        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/user/keys");

        System.out.println("POST Response: " + response.asString());
        Reporter.log("POST Response: " + response.asString());

        Assert.assertEquals(response.statusCode(), 201, "Status code mismatch!");

        // Extract the SSH key ID
        keyId = response.jsonPath().getInt("id");
        System.out.println("Generated SSH Key ID: " + keyId);

        Assert.assertTrue(keyId > 0, "Failed to extract SSH key ID!");
    }

    // -------------------------
    // 2. GET: Retrieve SSH Key
    // -------------------------
    @Test(priority = 2)
    public void getSSHKey() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .get("/user/keys/{keyId}");

        System.out.println("GET Response: " + response.asString());
        Reporter.log("GET Response: " + response.asString());

        Assert.assertEquals(response.statusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getInt("id"), keyId, "Key ID mismatch!");
    }

    // -------------------------
    // 3. DELETE: Remove SSH Key
    // -------------------------
    @Test(priority = 3)
    public void deleteSSHKey() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .delete("/user/keys/{keyId}");

        System.out.println("DELETE Response status: " + response.statusCode());
        Reporter.log("DELETE Response: " + response.statusCode());

        Assert.assertEquals(response.statusCode(), 204, "Failed to delete the SSH key!");
    }
}
