package test2.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Test2Steps {
    private WebDriver driver;

    @Given("I open Western Union site")
    public void i_open_western_union_site() {
        final String startUrl = "https://www.westernunion.com/lt/en/home.html";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to(startUrl);
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
    }

    @When("I press Find locations button")
    public void i_press_find_locations_button() {
        driver.findElement(By.xpath("//*[@id='header-content']/header/div/nav/ul[1]/li[3]/a/span")).click();
    }

    @And("on the next page I choose my zip code {string}")
    public void on_the_next_page_i_choose_my_zip_code(String zipCode) {
        driver.switchTo().frame(driver.findElement(By
                .xpath("//*[@src='//locations.westernunion.com/?iframe=true&locale=en_LT']")));
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys(String.valueOf(zipCode));
    }

    @And("hit Continue button")
    public void hit_continue_button() {
        driver.findElement(By.xpath("//*[@id='__next']/div[1]/main/div/button/span[1]")).click();
    }
    @And("on the next page I hit Open now button")
    public void on_the_next_page_i_hit_open_now_button() {
        driver.findElement(By.xpath("//*[@id='__next']/div[1]/main/form/div[3]/div/div[1]/button/span[1]"))
                .click();
    }
    @Then("I can get address details of the first location printed in console")
    public void i_can_get_address_details_of_the_first_location_printed_in_console() {
        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id='__next']/div[1]/main/div[1]/div[1]/ol")));
        driver.quit();
    }
}
