package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;


import helpers.Utility;

public class BaseClass extends Utility{

    public BaseClass() {
        propertyInit();
    }
    public static void intialization() {

        String browserName = prop.getProperty("Browser");
        if (browserName.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/java/tools/chromedriver/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(prop.getProperty("url"));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
