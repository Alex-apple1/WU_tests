package test1.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontPage extends AbstractBasePage {
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    private WebElement trustAcceptButton;
    @FindBy(css = "#hamburger-nav-item")
    private WebElement hamburgerButton;
    @FindBy(xpath = "//*[@id='hamburger-nav-item']/ul/li[6]/a")
    private WebElement hamburgerButtonSettings;
    @FindBy(css = "#Question")
    private WebElement selectCountryField;
    @FindBy(xpath = "//*[@id='Question']/option[212]")
    private WebElement selectUSAOption;
    @FindBy(xpath = "//*[@id='settingsPage']/maincontents/div[3]/div[2]/div[2]/button/translate")
    private WebElement selectUSAOptionConfirmation;
    @FindBy(xpath = "//*[@id='header-content']/header/div/nav/ul[1]/li[3]/a/span")
    private WebElement findLocationsButton;

    public FrontPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        openFrontPage();
    }
    public void clickTrustAcceptButton() {
        trustAcceptButton.click();
    }
    public void clickHamburgerButton() {
        hamburgerButton.click();
    }
    public void clickHamburgerButtonSettings() {
        hamburgerButtonSettings.click();
    }
    public void clickSelectCountryFieldAndSelectUSA() {
        selectCountryField.click();
        selectUSAOption.click();
        selectUSAOptionConfirmation.click();
    }
    public void pressFindLocationsButton() {
        findLocationsButton.click();
    }
}
