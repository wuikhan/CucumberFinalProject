Feature: Test Login functionaility
  The user should be able to login using valid credentials

  Scenario: Login using valid credentials
    Given I open chrome browser
    When I go to the homepage
    Then I should see logo
    And I enter username
    And I enter password
    When I click login button
    Then I should see log out
    And I quit
    And I generate the report 