package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {
    private @FindBy(css = "input#text")
    WebElement username_TextField;

    private @FindBy(css = "input#password")
    WebElement password_TextField;

    private @FindBy(css = "button#login-button")
    WebElement login_Button;

    public Login_PO() {
        super();
    }

    public void navigateTo_WebDriverUniversity_Login_Page() {
        navigateTo_URL("http://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    public void setUsername(String username) {
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password) {
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button() {
        waitForWebElementAndClick(login_Button);
    }
}

