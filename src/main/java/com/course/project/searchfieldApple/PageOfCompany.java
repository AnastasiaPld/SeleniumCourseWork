package com.course.project.searchfieldApple;

import com.course.project.registration.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageOfCompany extends BasePage {

    @FindBy(xpath = "//span[text()='Forward Dividend & Yield']/../following-sibling::td")
    private WebElement dividend;

    public PageOfCompany(WebDriver driver) {
        super(driver);
    }


    public String getDividend() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(dividend), 4);

        return dividend.getText();
    }

}



