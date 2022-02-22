package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.LoginSteps;

public class LoginStepDefinitions {

    private String roleType;

    @Steps
    private LoginSteps loginSteps;

    private String defaultLanguage = "English";

    @Given("I want to access as a {string}")
    public void iWantToAccessAsA(String role) {
        roleType = role;
    }

    @When("I login using {string} {string} with language {string}")
    public void iLoginUsingWithLanguage(String username, String password, String language) {
        loginSteps.loginUsingCredentials(username,password,language);
    }

    @Then("I should see I am logged in")
    public void iShouldSeeIAmLoggedIn() {
        loginSteps.verifyIAmLoggedInAs(roleType);
    }



}
