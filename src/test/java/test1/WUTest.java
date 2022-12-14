package test1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WUTest extends StarterClass {

    @Test
    public void task1Test() throws InterruptedException {
        String expectedURL = "https://www.westernunion.com/us/en/home.html";

        frontPage
                .open()
                .clickTrustAcceptButton()
                .clickHamburgerButton()
                .clickHamburgerButtonSettings()
                .clickSelectCountryFieldAndSelectUSA();

        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
    }
}
