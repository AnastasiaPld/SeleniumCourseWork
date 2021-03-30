package com.course.project.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public void submitData(String name, String surname, String mail, String pass, String telephone, String day, String year) {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(firstName), 4);
        firstName.sendKeys(name);
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(lastName), 4);
        lastName.sendKeys(surname);
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(emailAddress), 4);
        emailAddress.sendKeys(mail);
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(password), 4);
        password.sendKeys(pass);
        phoneNumber.sendKeys(telephone);
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(phoneNumber), 4);
        Select month = new Select(birthMonth);
        month.selectByValue("3");
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(birthMonth), 4);
        birthDate.sendKeys(day);
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(birthDate), 4);
        birthYear.sendKeys(year);
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(birthYear), 4);
        signUpBtn.click();
    }



}







