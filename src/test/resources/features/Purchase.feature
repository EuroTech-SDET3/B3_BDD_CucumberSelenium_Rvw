Feature: the user should be able to place order from the website

  Background: Go to home page
    Given the user is on the login page

@purchase
    Scenario: Placing a successful order
      When the user enters "etsB3@gmail.com" and "Test123++" and click login button
      And the user adds "Samsung galaxy s7" from "Phones"
      And the user adds "MacBook air" from "Laptops"
      And the user adds "Sony vaio i5" from "Laptops"
      And the user adds "Apple monitor 24" from "Monitors"
      And the user removes "Sony vaio i5" from cart
      And the user places order and captures and log amount
      Then the user verifies purchase amount equals 1900


