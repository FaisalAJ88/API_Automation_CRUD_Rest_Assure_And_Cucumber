package pages;

import org.openqa.selenium.By;
import static helper.Utility.driver;

public class WebPage {

    By input_username = By.id("user-name");

    By input_pwd = By.id("password");

    By btn_login = By.id("login-button");

    By icon_cart = By.xpath("//a[@class='shopping_cart_link']");

    By error_msg (String errormsg) {
        return By.xpath("//*[contains(text(), '"+ errormsg +"')]");
    }

    public void OpenBrowser() {
        driver.get("https://www.saucedemo.com/");
    }

    public void InputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void InputPwd(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);
    }

    public void ClickBtnLogin() {
        driver.findElement(btn_login).click();
    }

    public void verifyHomepage() {
        driver.findElement(icon_cart).isDisplayed();
    }

    public void assertErrorMsg(String errormsg) {
        driver.findElement(error_msg(errormsg)).isDisplayed();
    }
}
