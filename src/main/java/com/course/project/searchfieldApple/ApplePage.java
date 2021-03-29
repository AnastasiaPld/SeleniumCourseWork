package com.course.project.searchfieldApple;

import com.course.project.registration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplePage extends BasePage {

    @FindBy(xpath = "//span[text()='Forward Dividend & Yield']/../following-sibling::td")
    private WebElement dividend;

    public ApplePage(WebDriver driver) {
        super(driver);
    }

    public WebElement numberOfDividend(){
        return dividend;
    }
}
