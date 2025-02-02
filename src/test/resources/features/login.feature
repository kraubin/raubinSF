Feature: Login to Salesforce

  Scenario: User logs into Salesforce
    Given I am on the Salesforce login page
    When I enter valid credentials
    Then I should be redirected to the home page
