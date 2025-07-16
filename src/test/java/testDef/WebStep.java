package testDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebPage;

public class WebStep {

    WebPage webPage;

    public WebStep () {
        this.webPage  = new WebPage();
    }
    @Given("Open web login page")
    public void openWebLoginPage() {
        webPage.OpenBrowser();
    }
    @And("User input valid username {string}")
    public void userInputValidUsernameUsername(String username) {
        webPage.InputUsername(username);
    }

    @And("User input valid password {string}")
    public void userInputValidPasswordPassword(String pwd) {
        webPage.InputPwd(pwd);
    }

    @And("Click login button")
    public void clickLoginButton() {
        webPage.ClickBtnLogin();
    }

    @And("User will see icon cart in Homepage")
    public void userWillSeeIconCartInHomepage() throws InterruptedException {
        webPage.verifyHomepage();
        Thread.sleep(2000);
    }

    @And("User will see error message {string}")
    public void userWillSeeErrorMessage(String errormsg) {
        webPage.assertErrorMsg(errormsg);
    }

    @Then("Take Capture Full Screen {string}")
    public void takeCaptureFullScreen(String capture) {
        webPage.screenshot(capture);
    }
}
