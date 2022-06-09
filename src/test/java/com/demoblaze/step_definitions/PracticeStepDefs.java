package com.demoblaze.step_definitions;

import com.demoblaze.pages.PracticePage;
import static com.demoblaze.utulities.BrowserUtils.*;
import com.demoblaze.utulities.ConfigurationReader;
import com.demoblaze.utulities.Driver;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class PracticeStepDefs {

    PracticePage practicePage = new PracticePage();
    int actualValue;

    @Given("the user is on the demoqa slider page")
    public void the_user_is_on_the_demoqa_slider_page() {

        Driver.get().get(ConfigurationReader.get("urlPractice"));

    }

    @Then("the user verify that default slider is {int}")
    public void the_user_verify_that_default_slider_is(int expectedValue) {
        System.out.println("practicePage.sliderValue.getText() = " + practicePage.sliderValue.getAttribute("value"));
        String value=practicePage.sliderValue.getAttribute("value");
        actualValue=Integer.parseInt(value);
        assertEquals(expectedValue,actualValue);


    }

    @When("the user slides the slider")
    public void the_user_slides_the_slider() {

        WebElement slider= Driver.get().findElement(By.xpath("//input[@type='range']"));

        //birinci yol
//        Actions move = new Actions(Driver.get());
//        Action action = (Action) move.dragAndDropBy(slider, 30, 0).build();
//        action.perform();


        //ikinci yol
        for (int i = 0; i <60 ; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i <40 ; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        waitFor(2);

    }

    @Then("the user verify that slider is {int}")
    public void the_user_verify_that_slider_is(int expectedValue) {
        String value=practicePage.sliderValue.getAttribute("value");
        actualValue=Integer.parseInt(value);
        assertEquals(expectedValue,actualValue);

    }


}
