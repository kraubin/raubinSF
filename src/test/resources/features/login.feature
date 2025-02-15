@Xray @XSP-58  # Replace XSP-58 with your actual test case ID
Feature: Login to Salesforce

  Scenario: User logs into Salesforce
    Given User is on the Salesforce login page
    When User enters valid credentials
    And Clicks login button
    Then User should see the homepage
