package com.course.project.searchfieldApple;

import com.course.project.registration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatisticPage extends BasePage {

    @FindBy(xpath = "//span[text()='Price/Book']/..//following-sibling::td")
    private WebElement priceBook;

    public StatisticPage(WebDriver driver) {
        super(driver);
    }
    public String getPriceOfABook() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(priceBook), 4);

        return priceBook.getText();
    }
}
