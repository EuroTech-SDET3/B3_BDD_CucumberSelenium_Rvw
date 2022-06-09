package com.demoblaze.pages;

import com.demoblaze.utulities.BrowserUtils;
import com.demoblaze.utulities.ConfigurationReader;
import com.demoblaze.utulities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login2")
    public WebElement loginHomePage_loc;

    @FindBy(id = "loginusername")
    public WebElement login_Username_loc;

    @FindBy(id = "loginpassword")
    public WebElement login_Password_loc;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginButton_loc;

    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername_loc;


    public void login_method() {
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        loginHomePage_loc.click();
        login_Username_loc.sendKeys(username);
        login_Password_loc.sendKeys(password);
        loginButton_loc.click();
        BrowserUtils.waitFor(2);

    }

    public void verifyLogin_Method(String expectedUsername){
        BrowserUtils.waitFor(1);
        String actualUsername=welcomeUsername_loc.getText();
        Assert.assertEquals("username do NOT match",expectedUsername,actualUsername);
        System.out.println("expectedUsername = " + expectedUsername);
        System.out.println("actualUsername = " + actualUsername);

    }
    public void loginWithParameter_method(String username,String password){

        BrowserUtils.waitForClickablility(loginHomePage_loc,2).click();
        BrowserUtils.waitFor(2);
        login_Username_loc.sendKeys(username);
        login_Password_loc.sendKeys(password);
        loginButton_loc.click();
        BrowserUtils.waitFor(2);

    }

    public void verifyWithPopUpMessage_Method(String expectedMessage){
        Alert alert= Driver.get().switchTo().alert();
        String actualMesage=alert.getText();

        Assert.assertEquals("Message does NOT match",expectedMessage,actualMesage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMesage = " + actualMesage);


    }




}