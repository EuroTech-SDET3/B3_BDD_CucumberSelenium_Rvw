package com.demoblaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends BasePage {

    @FindBy(xpath = "//input[@id='sliderValue']")
    public WebElement sliderValue;


}
