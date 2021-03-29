package com.course.project.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(id = "header-signin-link")
    private WebElement signInBtn;

    @FindBy (xpath = "//div[@class='con-wizard']//ancestor::div[@class='wizard-body']//ancestor::div[@class='actions couple']//button")
    private WebElement cookieBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement signIn(){

        return signInBtn;
    }

    public void cookieButton(){
        cookieBtn.submit();

    }

    }








