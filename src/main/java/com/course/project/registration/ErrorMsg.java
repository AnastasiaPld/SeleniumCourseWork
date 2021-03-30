package com.course.project.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorMsg extends BasePage {

    @FindBy(id = "reg-error-yid")
    private WebElement emailErrorMsg;

    @FindBy(id = "reg-error-password")
    private WebElement passErrorMsg;

    @FindBy(id = "reg-error-phone")
    private WebElement phoneErrorMsg;

    @FindBy(id = "reg-error-birthDate")
    private WebElement birthDataErrorMsg;

    public ErrorMsg(WebDriver driver) {
        super(driver);
    }

    public String errorMsgEmail() {
        return emailErrorMsg.getText();
    }

    public String errorMsgPassword() {
        return passErrorMsg.getText();
    }

    public String errorMsgGsm() {
        return phoneErrorMsg.getText();
    }

    public String errorMsgDataOfBirth() {
        return birthDataErrorMsg.getText();
    }



}
