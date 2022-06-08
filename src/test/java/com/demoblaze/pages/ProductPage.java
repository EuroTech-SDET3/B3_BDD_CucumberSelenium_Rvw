package com.demoblaze.pages;

import com.demoblaze.utulities.BrowserUtils;
import com.demoblaze.utulities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCart_loc;

    @FindBy (xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink_loc;




        public void addProduct_Method(String category, String product){
            WebElement categoryElm= Driver.get().findElement(By.xpath("//a[.='"+category+"']"));
            BrowserUtils.waitForClickablility(categoryElm,3).click();
            WebElement productElm=Driver.get().findElement(By.xpath("//a[.='"+product+"']"));
            BrowserUtils.scrollToElement(productElm);
            BrowserUtils.waitForClickablility(productElm,3).click();
            BrowserUtils.waitFor(1);

            addToCart_loc.click();

            BrowserUtils.waitFor(1);
            Alert alert=Driver.get().switchTo().alert();
            alert.accept();

            homeLink_loc.click();




        }
}
