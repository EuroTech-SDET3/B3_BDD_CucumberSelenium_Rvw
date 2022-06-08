package com.demoblaze.pages;

import com.demoblaze.utulities.BrowserUtils;
import com.demoblaze.utulities.Driver;
import com.github.javafaker.Faker;
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
        placeOrderButton_loc.click();
        fillForm_Method();
        purchaseButton_loc.click();



    }


}
