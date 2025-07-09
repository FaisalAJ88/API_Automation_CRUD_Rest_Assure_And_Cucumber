package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders () {
        request = RestAssured.given ()
                // Set header here
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer f564bf850f05ea549108f7836057a79a9eb406d461b4813df2a5af3186edcc38");
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response DeleteUsers(String endpoint , String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }
    public static Response postCreateUsers(String endpoint) {
        String name = "Faisal Adi Jayadi";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "Active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response UpdateUsers(String endpoint , String user_id) {
        setupHeaders();

        String name = "Faisal Adi";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "Active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }
}