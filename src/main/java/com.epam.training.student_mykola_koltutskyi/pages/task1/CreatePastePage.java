package com.epam.training.student_mykola_koltutskyi.pages.task1;

import com.epam.training.student_mykola_koltutskyi.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.epam.training.student_mykola_koltutskyi.drivers.DriverWaiter.*;

public class CreatePastePage extends AbstractPage {

    @FindBy(xpath = "//a[@class='header__btn']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//textarea[@aria-label='New Paste']")
    private WebElement codeTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//ul[@class='select2-results__options']/li")
    private List<WebElement> pasteExpirationOptions;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteNameTextArea;

    @FindBy(xpath = "//vli[@class=\"vliIgnore\"]")
    private WebElement closeAddButton;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createPasteButton;

    private final WebDriver driver;

    public CreatePastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CreatePastePage openPage(String url) {
        driver.navigate().to(url);
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public CreatePastePage sendCodeSequence(String keySequence) {
        sendKeys(codeTextArea, keySequence);
        return this;
    }

    public CreatePastePage clickOnPageExpiration() {
        closeAddButton.click();
        moveToElement(pasteExpirationDropdown);
        waitForElementToBeClickable(pasteExpirationDropdown).click();
        return this;
    }

    public CreatePastePage selectFromDropdownList(String dropdownElementName) {
        pasteExpirationOptions.stream()
                .filter((element) -> element.getText().equals(dropdownElementName))
                .findAny()
                .ifPresent(WebElement::click);

        return this;
    }

    public String getExpirationTime() {
        waitForAttributeToBe(pasteExpirationDropdown, "title", "10 Minutes");
        return pasteExpirationDropdown.getText();
    }

    public CreatePastePage setPasteTitle(String title) {
        sendKeys(pasteNameTextArea, title);

        return this;
    }

    public PastePage createNewPaste() {
        createNewPasteButton.click();
        return new PastePage(driver);
    }

    private void sendKeys(WebElement element, String keySequence) {
        element.sendKeys(keySequence);
    }

    private void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}