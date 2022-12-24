package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {

    private WebDriver driver;

    @Before("@login")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nero\\Desktop\\Resources\\CucumberWorkSpace\\automation-framework\\src\\main\\java\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void teardown(){
        driver.quit();
    }
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    @When("I enter a specific username {string}")
    public void i_enter_a_specific_username_webdriver(String username) {
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
}
