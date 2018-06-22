package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }



    @Before
        public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public static void afterMethod(){
        driver .quit();
    }

}