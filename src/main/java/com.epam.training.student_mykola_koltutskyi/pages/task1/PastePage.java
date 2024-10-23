package com.epam.training.student_mykola_koltutskyi.pages.task1;

import com.epam.training.student_mykola_koltutskyi.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='info-top']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//div[@class='de1']")
    private WebElement pasteCode;

    public PastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPasteTitle() {
        return pasteTitle.getText();
    }

    public String getPasteCode() {
        return pasteCode.getText();
    }
}
