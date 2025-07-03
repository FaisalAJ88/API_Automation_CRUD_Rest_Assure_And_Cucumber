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
}