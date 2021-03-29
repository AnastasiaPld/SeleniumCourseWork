package com.course.project.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(id = "usernamereg-firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "yid")
    private WebElement emailAddress;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "phone")
    private WebElement phoneNumber;

    @FindBy(name = "mm")
    private WebElement birthMonth;

    @FindBy(name = "dd")
    private WebElement birthDate;

    @FindBy(name = "yyyy")
    private WebElement birthYear;

    @FindBy(name = "signup")
    private WebElement signUpBtn;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement firstN() {
        return firstName;
    }

    public WebElement lastN() {
        return lastName;
    }

    public WebElement emailAdd() {
        return emailAddress;
    }

    public WebElement pass() {
        return password;
    }

    public WebElement phone() {
        return phoneNumber;
    }

    public WebElement monthOfBirth() {
        return birthMonth;
    }

    public WebElement dateOfBirth() {
        return birthDate;
    }

    public WebElement yearOfBirth() {
        return birthYear;
    }

    public WebElement signUp() {
        return signUpBtn;
    }
}






