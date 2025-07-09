package testDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.apiPage;
import io.cucumber.java.en.Given;

public class apiStep {

    apiPage ApiPage;

    public apiStep () {
        this.ApiPage = new apiPage();
    }

    @Given("Prepare URL for {string}")
    public void prepareURLFor(String url) {
        ApiPage.prepareURLFor(url);
    }

    @And("Hit API get list users")
    public void hitAPIGetListUsers() {
        ApiPage.hitAPIGetListUsers();
    }

    @Then("Validate status code is equals {int}")
    public void validateStatusCodeIsEquals(int status_code) {
        ApiPage.validateStatusCodeIsEquals(status_code);
    }

    @Then("Validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        ApiPage.validationResponseBodyGetListUsers();
    }

    @Then("Validation response JSON with JSON Schema {string}")
    public void validationResponseJSONWithJSONSchema(String filename) {
        ApiPage.validationResponseJSONWithJSONSchema(filename);
    }

    @And("Hit API post created users")
    public void hitAPIPostCreatedUsers() {
        ApiPage.hitAPIPostCreateUsers();
    }

    @Then("Validation response body get create users")
    public void validationResponseBodyGetCreateUsers() {
        ApiPage.validationResponseBodyGetCreateUsers();
    }

    @Then("Validation response body get created users")
    public void validationResponseBodyGetCreatedUsers() {
        ApiPage.validationResponseBodyGetCreatedUsers();

    }

    @And("Hit API delete new")
    public void hitAPIDeleteNew() {
        ApiPage.hitAPIDeleteUser();
    }

    @And("Hit API update user")
    public void hitAPIUpdateUser() {
        ApiPage.hitAPIUpdateUser();
    }

    @Then("Validation response body update users")
    public void validationResponseBodyUpdateUsers() {
        ApiPage.validationResponeBodyUpdateUser();
    }
}