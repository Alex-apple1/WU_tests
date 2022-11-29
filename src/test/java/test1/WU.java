package test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WU {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        String driverName = "Chrome driver";
        context.setAttribute(driverName, driver);
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void clear() {
        driver.quit();
    }

    @Test
    public void task1Test() {
        String startUrl = "https://www.westernunion.com/lt/en/home.html";
        String expectedURL = "https://www.westernunion.com/us/en/home.html";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to(startUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id='onetrust-accept-btn-handler']")));
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.cssSelector("#hamburger-nav-item")).click();
        driver.findElement(By.xpath("//*[@id='hamburger-nav-item']/ul/li[6]/a")).click();
        driver.findElement(By.cssSelector("#Question")).click();
        driver.findElement(By.xpath("//*[@id='Question']/option[212]")).click();
        driver.findElement(By
                .xpath("//*[@id='settingsPage']/maincontents/div[3]/div[2]/div[2]/button/translate")).click();
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL));
    }
}
