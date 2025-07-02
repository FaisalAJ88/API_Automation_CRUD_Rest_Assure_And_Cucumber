package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders () {
        request = RestAssured.given ()
                // Set header here
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 2dcea73828a331430f8b14605e7e58adf1aa518af8cd0488a549a49c1fe0ad65");
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }
}

