package test1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test1.model.FrontPage;

public class WU{
    private WebDriver driver;
    @BeforeClass
    public void beforeClass(ITestContext context) {
        context.setAttribute("driver", driver);
    }
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void clear() {
        driver.quit();
    }

    @Test
    public void task1Test() throws InterruptedException {
        String expectedURL = "https://www.westernunion.com/us/en/home.html";

        String frontPageUrl = "https://www.westernunion.com/lt/en/home.html";
        driver.navigate().to(frontPageUrl);

        FrontPage frontPage = new FrontPage(driver);
        Thread.sleep(2000);
        frontPage.clickTrustAcceptButton();
        frontPage.clickHamburgerButton();
        frontPage.clickHamburgerButtonSettings();
        frontPage.clickSelectCountryFieldAndSelectUSA();

        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
    }
}
