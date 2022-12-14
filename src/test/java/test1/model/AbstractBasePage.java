package test1.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractBasePage {
    private static final String BASE_URL = "https://www.westernunion.com/lt/en/home.html";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void openFrontPage() {
        driver.navigate().to(BASE_URL);
    }
}
