package com.course.project.registration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SignInPage extends BasePage {
    @FindBy(xpath ="//a[@id='header-signin-link']//.//ancestor::span[text()='Sign in']")
    private WebElement signInBtn;

    @FindBy (xpath = "//div[@class='con-wizard']//ancestor::div[@class='wizard-body']//ancestor::div[@class='actions couple']//button")
    private WebElement cookieBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccount SignInBtn(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",cookieBtn);
        cookieBtn.click();
        executeOperationWithExplicitWait(15, ExpectedConditions.invisibilityOfElementLocated(By.xpath("/div[@class='con-wizard']//ancestor::div[@class='wizard-body']//ancestor::div[@class='actions couple']//button")), 4);
        executeOperationWithExplicitWait(10, ExpectedConditions.elementToBeClickable(signInBtn), 4);
        signInBtn.click();
        return new CreateAccount(driver);
    }



    }










