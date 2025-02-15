Feature: Login to Salesforce

  @Xray @XSP-58  # This links the test to Jira Xray
  Scenario: User logs into Salesforce
    Given User is on the Salesforce login page
    When User enters valid credentials
    And Clicks login button
    Then User should see the homepage
