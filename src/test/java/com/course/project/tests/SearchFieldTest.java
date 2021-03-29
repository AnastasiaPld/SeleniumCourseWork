package com.course.project.tests;

import com.course.project.base.TestUtil;
import com.course.project.searchfieldApple.ApplePage;
import com.course.project.searchfieldApple.MainPage;
import com.course.project.searchfieldApple.StatisticPage;
import com.course.project.searchfieldApple.Statistics;
import com.course.project.utils.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchFieldTest extends TestUtil {
    @DataProvider(name = "statistical-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/statistical-data.csv");
    }

    @Test(dataProvider = "statistical-data")
    public void executeSearch(String firmA, String number, String price) throws InterruptedException, IOException, CsvException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MainPage mainpage = new MainPage(driver);
        mainpage.searchAppleCompany(firmA);

        ApplePage applepage = new ApplePage(driver);
        applepage.getAppleDividend();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(applepage.getAppleDividend(), number);

        Statistics statisticNewPage = new Statistics(driver);
        statisticNewPage.newPageStatistic();

        StatisticPage statisticBook= new StatisticPage(driver);
        statisticBook.getPriceOfABook();

        softAssert.assertEquals(statisticBook.getPriceOfABook(),price);
        softAssert.assertAll();

    }
}
