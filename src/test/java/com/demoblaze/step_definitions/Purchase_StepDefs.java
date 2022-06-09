package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {

    ProductPage productPage=new ProductPage();
    CartPage cartPage=new CartPage();


    @When("the user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
            productPage.addProduct_Method(category,product);
    }

    @When("the user removes {string} from cart")
    public void the_user_removes_from_cart(String removeProduct) {
        cartPage.removeProduct_Method(removeProduct);

    }

    @When("the user places order and captures and log amount")
    public void the_user_places_order_and_captures_and_log_amount() {
        cartPage.finishPurchase_Method();

    }


    @Then("the user verifies purchase amount equals {int}")
    public void theUserVerifiesPurchaseAmountEquals(int expectedAmount) {

        cartPage.verifyAmount_Method(expectedAmount);
    }
}
