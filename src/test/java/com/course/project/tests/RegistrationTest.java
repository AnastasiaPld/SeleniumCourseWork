package com.course.project.tests;

import com.course.project.base.TestUtil;
import com.course.project.registration.ErrorMsg;
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

public class RegistrationTest extends TestUtil {

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-data")
    public void executeSignUp(String name, String surname, String mail, String pass,String gsm, String day, String year){
        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignInBtn();

        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.createAccountBtn();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.submitData(name,surname,mail,pass,gsm,day,year);

        ErrorMsg errorValidation=new ErrorMsg(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(errorValidation.errorMsgEmail(),"That email address is too short, please use a longer one.");
        softAssert.assertEquals(errorValidation.errorMsgPassword(),"Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(errorValidation.errorMsgGsm(), "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(errorValidation.errorMsgDataOfBirth(), "That doesn’t look right, please re-enter your birthday.");

    }


}

