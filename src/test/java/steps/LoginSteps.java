package steps;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("User is on the Salesforce login page")
    public void user_is_on_the_salesforce_login_page() {
        System.out.println("Navigating to Salesforce login page");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        System.out.println("Entering valid username and password");
    }

    @When("Clicks login button")
    public void clicks_login_button() {
        System.out.println("Clicking the login button");
    }

    @Then("User should see the homepage")
    public void user_should_see_the_homepage() {
        System.out.println("User is on the homepage");
    }
}
