package com.course.project.searchfieldApple;

import com.course.project.registration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsSection extends BasePage {


    @FindBy(xpath = "//li[@data-test='STATISTICS']//..//following::span[text()='Statistics']")
    private WebElement statisticsSection;

    public StatisticsSection(WebDriver driver) {
        super(driver);
    }
public StatisticPage newPageStatistic (){
        statisticsSection.click();
        return new StatisticPage(driver);

}
}