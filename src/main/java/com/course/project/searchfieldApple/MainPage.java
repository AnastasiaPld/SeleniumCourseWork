package com.course.project.searchfieldApple;

import com.course.project.registration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='con-wizard']//ancestor::div[@class='wizard-body']//ancestor::div[@class='actions couple']//button")
    private WebElement cookieBtn;

    @FindBy(name = "yfin-usr-qry")
    WebElement searchField;

    @FindBy(id = "result-quotes-0")
    WebElement dropdownMenu;

    @FindBy(className = "search")
    WebElement searchBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement cookieButton() {
        return cookieBtn;
    }

    public WebElement searchF() {
        return searchField;
    }

    public WebElement dropMenu(){
        return dropdownMenu;
    }

    public WebElement searchButton() {
        return searchBtn;
    }
}




