package test1.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindLocationPage extends AbstractBasePage {
    @FindBy(xpath = "//*[@src='//locations.westernunion.com/?iframe=true&locale=en_LT']")
    private WebElement iFrameAreaLocator;
    @FindBy(xpath = "//*[@type='search']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/div/button/span[1]")
    private WebElement continueButton;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/form/div[3]/div/div[1]/button/span[1]")
    private WebElement openNowButton;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/form/div[3]/div/div[1]/button/span[1]")
    private WebElement firstResultInTheTable;

    public FindLocationPage(WebDriver driver) {
        super(driver);
    }
    public void enterZipCode(String zipCode) {
        driver.switchTo().frame(iFrameAreaLocator);
        zipCodeField.sendKeys(String.valueOf(zipCode));
    }
    public void hitContinueButton() {
        continueButton.click();
    }
    public void hitOpenNowButton() {
        openNowButton.click();
    }
    public String getFirstResultInTheTable() {
        return firstResultInTheTable.getText();
    }
}
