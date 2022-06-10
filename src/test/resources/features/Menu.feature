Feature: Menu List

  Scenario: Verify Menu List

    #open the https://www.demoblaze.com/
    #Username ve password encrypted halde con.pro bulunsun
    # Log in(kendi kulllaniciniz ile)
    #Categories menusunde bulunan "Phone" "Laptops" "Monitors" leri verify et

    Given the user is on the login page
    When the user enters valid credentials
    Then the user able to see following categories
    |Phones|
    |Laptops|
    |Monitors|

  @menu
Scenario: Add new credential to the Configuration Properties

  Given the user is on the login page
  When the user enters valid credentials
  And  the user get sony laptops name
  Then the compiler adds laptops name to the Configuration Properties

