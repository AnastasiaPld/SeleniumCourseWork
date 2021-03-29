package com.course.project.tests;

import com.course.project.base.TestUtil;
import com.course.project.searchfieldApple.ApplePage;
import com.course.project.searchfieldApple.MainPage;
import com.course.project.utils.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatisticalData extends TestUtil {


    @DataProvider(name = "statistical-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/statistical-data.csv");
    }

    @Test(dataProvider = "statistical-data")
    public void executeSearch(String firmA, String number, String firmB,String number1) throws InterruptedException, IOException, CsvException {

        WebDriverWait wait = new WebDriverWait(driver, 15);

        MainPage mainpage = new MainPage(driver);
        mainpage.cookieButton().submit();
        mainpage.searchF().sendKeys(firmA);
        mainpage.dropMenu().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("className = search")));
        mainpage.searchButton().click();


        ApplePage applepage = new ApplePage(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Forward Dividend & Yield']/..//following-sibling::td")));
        applepage.numberOfDividend().getText();


        SoftAssert softAssert = new SoftAssert();
        String actualNumber = driver.findElement(By.xpath("//span[text()='Forward Dividend & Yield']/..//following-sibling::td")).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Forward Dividend & Yield']/..//following-sibling::td")));
        softAssert.assertEquals(actualNumber,number);
        softAssert.assertAll();

    }


}

