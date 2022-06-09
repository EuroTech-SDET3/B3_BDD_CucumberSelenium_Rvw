Feature: Login Test-the user should be able to login with valid credential

  Background: Go to home page
    Given the user is on the login page


  @loginWithOutParameters
  Scenario: Positive scenario 1-user should be able to login
    When the user enters valid credentials
    Then verify "Welcome etsB3"

  @loginWithParameters
  Scenario: Positive scenario 2-user should be able to login
    When the user enters "etsB3" and "Test123+" and click login button
    Then verify "Welcome etsB3"


  @loginWithScenarioOutline
  Scenario Outline: Positive scenario 3-user should be able to login
    When the user enters "<username>" and "<password>" and click login button
    Then verify "<message>"

    Examples:
      | username | password | message       |
      | etsB3    | Test123+ | Welcome etsB3 |


  @loginWithDataTableAndSCOutline
  Scenario Outline: Positive scenario 4-user should be able to login
    When the user enters valid username and password
      | username | <user>     |
      | password | <password> |

    Then verify "<message>"

    Examples:
      | user            | password  | message                 |
      | etsB3           | Test123+  | Welcome etsB3           |
      | etsB3@gmail.com | Test123++ | Welcome etsB3@gmail.com |

  @loginNegative
  Scenario Outline: Negative scenario-User should NOT be able to login with invalid credential
    When the user enters "<invalid username>" and "<invalid password>" and click login button
    Then verify invalid credential "<message>"
    Examples:
      | invalid username | invalid password | message                                |
      | etsB3invalid     | Test123+         | User does not exist.                   |
      | etsB3invalid     | Test123+++       | User does not exist.                   |
      | etsB3            | Test123+++       | Wrong password.                        |
      |                  | Test123+         | Please fill out Username and Password. |
      | etsB3            |                  | Please fill out Username and Password. |
      |                  |                  | Please fill out Username and Password. |
     # | etsB3            | 123              | password must be at least 8 characters |

  Scenario: Encryption Test
    When User enters encrypted credentials
    Then verify "Welcome etsB3"
