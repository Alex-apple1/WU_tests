package test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import test1.model.FindLocationPage;
import test1.model.FrontPage;

import java.util.concurrent.TimeUnit;

public class StarterClass {
    protected WebDriver driver;
    protected FrontPage frontPage;
    protected FindLocationPage findLocationPage;

    @AfterMethod
    public void clear() {
        driver.quit();
    }
    public StarterClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        frontPage = new FrontPage(driver);
        findLocationPage = new FindLocationPage(driver);
    }
}
