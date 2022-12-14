package test2.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import test1.StarterClass;

public class Test2Steps extends StarterClass {
    @Given("I open Western Union site")
    public void i_open_western_union_site() throws InterruptedException {
        frontPage.open();
        Thread.sleep(2000);
        frontPage.clickTrustAcceptButton();
    }
    @When("I press Find locations button")
    public void i_press_find_locations_button() {
        frontPage.pressFindLocationsButton();
    }
    @And("on the next page I choose my zip code {string}")
    public void on_the_next_page_i_choose_my_zip_code(String zipCode) {
        findLocationPage.enterZipCode(zipCode);
    }
    @And("hit Continue button")
    public void hit_continue_button() {
        findLocationPage.hitContinueButton();
    }
    @And("on the next page I hit Open now button")
    public void on_the_next_page_i_hit_open_now_button() {
        findLocationPage.hitOpenNowButton();
    }
    @Then("I can get address details of the first location printed in console")
    public void i_can_get_address_details_of_the_first_location_printed_in_console() {
        Assert.assertNotNull(findLocationPage.getFirstResultInTheTable());
        driver.quit();
    }
}
