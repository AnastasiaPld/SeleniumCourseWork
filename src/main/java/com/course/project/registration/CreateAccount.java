package com.course.project.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount extends BasePage {

    protected WebDriver driver;

    @FindBy(id = "createacc")
    private WebElement createAccountBtn;


    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    public WebElement createAccount(){
        return createAccountBtn;
    }

    }
