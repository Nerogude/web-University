package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;
public class Login_Steps extends Base_PO {

    private Login_PO login_po;
    public Login_Steps(Login_PO login_po){
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }
    @When("I enter a specific username {}")
    public void i_enter_a_username_webdriver(String username) {
       login_po.setUsername(username);
    }
    @And("I enter a specific password {}")
    public void i_enter_a_specific_password_webdriver123(String password) {
      login_po.setPassword(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
       login_po.clickOn_Login_Button();
    }
    @Then("I should be presented with a successful login validation message")
    public void i_should_be_presented_with_a_successful_login_validation_message() {
       login_po.validate_SuccessfulLogin_Message();
    }
    @Then("I should be presented with an unsuccessful login validation message")
    public void i_should_be_presented_with_an_unsuccessful_login_validation_message() {
        login_po.validate_UnSuccessfulLogin_Message();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message_validation_succeeded(String expectedMessage) {
       waitForAlert_And_ValidateText(expectedMessage);
    }
}
