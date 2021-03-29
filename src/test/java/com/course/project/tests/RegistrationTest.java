package com.course.project.tests;

import com.course.project.base.TestUtil;
import com.course.project.utils.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.course.project.registration.CreateAccount;
import com.course.project.registration.RegistrationPage;
import com.course.project.registration.SignInPage;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestUtil {

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-data")
    public void executeSignUp(String name, String surname, String mail, String pass,String gsm, String day, String year) throws IOException, CsvException{
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignInBtn();

        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.createAccountBtn();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.submitData(name,surname,mail,pass,gsm,day,year);

        SoftAssert softAssert = new SoftAssert();

        String emailErrorMsg = driver.findElement(By.id("reg-error-yid")).getText();
        softAssert.assertEquals(emailErrorMsg, "That email address is too short, please use a longer one.");

        String passErrorMsg = driver.findElement(By.id("reg-error-password")).getText();
        softAssert.assertEquals(passErrorMsg, "Your password isn’t strong enough, try making it longer.");

        String phoneErrorMsg = driver.findElement(By.id("reg-error-phone")).getText();
        softAssert.assertEquals(phoneErrorMsg, "That doesn’t look right, please re-enter your phone number.");

        String infoOfBirthDateErrorMsg = driver.findElement(By.id("reg-error-birthDate")).getText();
        softAssert.assertEquals(infoOfBirthDateErrorMsg, "That doesn’t look right, please re-enter your birthday.");

    }


}
