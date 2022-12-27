package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    private static ThreadLocal <WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (webDriver.get()==null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;


        if((getBrowserType()).equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nero\\Desktop\\Resources\\CucumberWorkSpace\\automation-framework\\src\\main\\java\\driver\\drivers\\chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
        } else  if((getBrowserType()).equals("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Nero\\Desktop\\Resources\\CucumberWorkSpace\\automation-framework\\src\\main\\java\\driver\\drivers\\msedgedriver.exe");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new EdgeDriver(edgeOptions);
        }
        driver.manage().window().maximize();
        return driver;
    }
    private static String getBrowserType()  {
        String browserType = null;
        try {
            Properties prop = new Properties();
            FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            prop.load(data);
            browserType = prop.getProperty("browser").toLowerCase().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return browserType;
    }


    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
