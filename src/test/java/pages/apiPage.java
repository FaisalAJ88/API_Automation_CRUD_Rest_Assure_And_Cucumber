package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.AssertionsForClassTypes;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;


public class apiPage {

String setURL , global_id;

Response res;

    public void prepareURLFor(String url) {
        switch (url) {
            case "GET_LIST_USERS" :
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATED_NEW_USERS" :
                setURL = Endpoint.CREATED_NEW_USERS;
                break;
            case "DELETE_LIST_USERS" :
                setURL = Endpoint.DELETE_LIST_USERS;
                break;
            case "UPDATE_LIST_USERS" :
                setURL = Endpoint.UPDATE_LIST_USERS;
                break;
            default:
                System.out.println("Input right URL");
        }
        System.out.println("Endpoint yang sudah di SetUp adalah : "+setURL);
    }

    public void hitAPIGetListUsers () {
        res = getListUsers (setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitAPIPostCreateUsers () {
        res = postCreateUsers (setURL);
        System.out.println(res.getBody().asString());
    }

    public void validateStatusCodeIsEquals (int status_code) {
        AssertionsForClassTypes.assertThat(res.statusCode()).isEqualTo(status_code);
        //assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        //System.out.println(id);

        assertThat(id.getFirst()).isNotNull();
        assertThat(name.getFirst()).isNotNull();
        assertThat(email.getFirst()).isNotNull();
        assertThat(gender.getFirst()).isIn("female", "male");
        assertThat(status.getFirst()).isIn("active","inactive");
    }

    public void validationResponseJSONWithJSONSchema(String filename) {
        File JSONFile = Utility.GetJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationResponseBodyGetCreateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        Integer name = jsonPathEvaluator.get("name");
        Integer email = jsonPathEvaluator.get("email");
        Integer gender = jsonPathEvaluator.get("gender");
        Integer status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }

    public void validationResponseBodyGetCreatedUsers(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    public void hitAPIDeleteUser() {
        res = DeleteUsers(setURL , global_id);
    }

    public void hitAPIUpdateUser() {
        res = UpdateUsers(setURL , global_id);
    }

    public void validationResponeBodyUpdateUser () {
        System.out.println(res.getBody().asString());
    }
}
