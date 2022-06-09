package com.demoblaze.step_definitions;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.utulities.ConfigurationReader;
import com.demoblaze.utulities.Driver;
import com.demoblaze.utulities.EncryptionUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login_method();
    }

    @Then("verify {string}")
    public void verify(String expectedUsername) {
        loginPage.verifyLogin_Method(expectedUsername);
    }

    @When("the user enters {string} and {string} and click login button")
    public void the_user_enters_and_and_click_login_button(String username, String password) {
       loginPage.loginWithParameter_method(username,password);
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password(Map<String,String> userInfo) {
        loginPage.loginWithParameter_method(userInfo.get("username"),userInfo.get("password"));


    }



    @Then("verify invalid credential {string}")
    public void verify_invalid_credential(String expectedMessage) {

        loginPage.verifyWithPopUpMessage_Method(expectedMessage);

    }


    @When("User enters encrypted credentials")
    public void userEntersEncryptedCredentials() {

        String username= EncryptionUtils.decrypt(ConfigurationReader.get("encryptedUsername"),System.getenv("secretKey"));
        String password= EncryptionUtils.decrypt(ConfigurationReader.get("encryptedPassword"),System.getenv("secretKey"));
        loginPage.loginWithParameter_method(username,password);


    }
}
