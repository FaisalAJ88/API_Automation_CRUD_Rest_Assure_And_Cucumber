Feature: Test Automation Web

  Scenario: Login web Saucedemo with Valid Credential
    Given Open web login page
    And User input valid username "standard_user"
    And User input valid password "secret_sauce"
    And Click login button
    And User will see icon cart in Homepage
    Then Take Capture Full Screen "success_login.png"

  Scenario: Login web Saucedemo with Invalid Password
    Given Open web login page
    And User input valid username "standard_user"
    And User input valid password "secret_sauce123"
    And Click login button
    And User will see error message "Username and password do not match"
    Then Take Capture Full Screen "error_username_password.png"

  Scenario: Login web Saucedemo with Blank Password Field
    Given Open web login page
    And User input valid username "standard_user"
    And User input valid password ""
    And Click login button
    And User will see error message "Password is required"
    Then Take Capture Full Screen "error_blank_pass.png"