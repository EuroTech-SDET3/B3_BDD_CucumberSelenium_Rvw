package com.demoblaze.pages;

import com.demoblaze.utulities.BrowserUtils;
import com.demoblaze.utulities.Driver;
import com.github.javafaker.Faker;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart_loc;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton_loc;

    @FindBy(id = "name")
    public WebElement name_loc;

    @FindBy(id = "country")
    public WebElement country_loc;

    @FindBy(id = "city")
    public WebElement city_loc;

    @FindBy(id = "card")
    public WebElement creditCard_loc;

    @FindBy(id = "month")
    public WebElement month_loc;

    @FindBy(id = "year")
    public WebElement year_loc;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton_loc;

    @FindBy(css = ".lead.text-muted ")
    public WebElement confirmation_loc;



    int actualAmount;



    public void removeProduct_Method(String product){
        cart_loc.click();
        BrowserUtils.waitFor(2);
        WebElement deleteProductElm= Driver.get().findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[.='Delete']/a"));

        deleteProductElm.click();

    }

    public void fillForm_Method(){
        Faker faker=new Faker();
        BrowserUtils.waitFor(1);
        name_loc.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        country_loc.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        city_loc.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        creditCard_loc.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month_loc.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        BrowserUtils.waitFor(1);
        year_loc.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        BrowserUtils.waitFor(1);

    }


    public void finishPurchase_Method(){
        BrowserUtils.waitFor(2);
        placeOrderButton_loc.click();
        BrowserUtils.waitFor(2);
        fillForm_Method();
        BrowserUtils.waitFor(2);
        purchaseButton_loc.click();
        BrowserUtils.waitFor(2);

        String confirmationNum= confirmation_loc.getText();

        String [] confirmationArray= confirmationNum.split("\n");

        //String array1=confirmationArray[1].split(" ")[1];
        actualAmount=Integer.parseInt(confirmationArray[1].split(" ")[1]);
      //  System.out.println("array1 = " + array1);
        System.out.println("amount = " + actualAmount);


    }
    public void verifyAmount_Method(int expectedAmount){
        assertEquals(expectedAmount,actualAmount);
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("actualAmount = " + actualAmount);

    }


}
