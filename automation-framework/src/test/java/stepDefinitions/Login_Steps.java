package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;



public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        navigateTo_URL("http://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    @When("I enter a specific username {}")
    public void i_enter_a_username_webdriver(String username) {
        driver.findElement(By.cssSelector("input#text")).sendKeys(username);


    }
    @And("I enter a specific password {}")
    public void i_enter_a_specific_password_webdriver123(String password) {
      driver.findElement(By.cssSelector("input#password")).sendKeys(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
       driver.findElement(By.cssSelector("button#login-button")).click();
    }
    @Then("I should be presented with a successful login validation message")
    public void i_should_be_presented_with_a_successful_login_validation_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation succeeded");
    }
    @Then("I should be presented with an unsuccessful login validation message")
    public void i_should_be_presented_with_an_unsuccessful_login_validation_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation failed");
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message_validation_succeeded(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,expectedMessage);
    }
}
