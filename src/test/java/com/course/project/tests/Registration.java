package com.course.project.tests;

import com.course.project.base.TestUtil;
import com.course.project.utils.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.course.project.registration.CreateAccount;
import com.course.project.registration.RegistrationPage;
import com.course.project.registration.SignInPage;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Registration extends TestUtil {

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-data")
    public void executeSignUp(String firstName, String lastName, String email, String pass,String dayOfBirth, String yearOfBirth) throws IOException, CsvException, InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.cookieButton();
        signInPage.signIn().click();

        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.createAccount().click();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.firstN().sendKeys(firstName);
        registrationPage.lastN().sendKeys(lastName);
        registrationPage.emailAdd().sendKeys(email);
        registrationPage.pass().sendKeys(pass);
        Select list = new Select(registrationPage.monthOfBirth());
        list.selectByValue("3");
        registrationPage.dateOfBirth().sendKeys(dayOfBirth);
        registrationPage.yearOfBirth().sendKeys(yearOfBirth);
        registrationPage.signUp().click();

        SoftAssert softAssert = new SoftAssert();

       String emailErrorMsg= driver.findElement(By.id("reg-error-yid")).getText();
       softAssert.assertEquals(emailErrorMsg,"That email address is too short, please use a longer one.");

       String passErrorMsg= driver.findElement(By.id("reg-error-password")).getText();
       softAssert.assertEquals(passErrorMsg,"Your password isn’t strong enough, try making it longer.");

       String phoneErrorMsg =driver.findElement(By.id("reg-error-phone")).getText();
       softAssert.assertEquals(phoneErrorMsg,"That doesn’t look right, please re-enter your phone number.");

       String infoOfBirthDateErrorMsg =driver.findElement(By.id("reg-error-birthDate")).getText();
       softAssert.assertEquals(infoOfBirthDateErrorMsg,"That doesn’t look right, please re-enter your birthday.");

    }


}
