package uitestlab.Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import uitestlab.Steps.TestContext;

public class CreateAccountSteps {

    private final TestContext context;

    public CreateAccountSteps(TestContext context) {
        this.context = context;
    }
    @When("^The user fills in the registration form$")
    public void theUserFillsInTheRegistrationForm() {
        context.pm.getAccountCreationPage().fillInCreateAccountForm("Test", "User", "1234567");
    }
    @When("^The user fills in first name \"(.*)\" and surname \"(.*)\" with password \"(.*)\"$")
    public void theUserFillsInFirstNameAndSurname(String firstName, String surname, String password) {
        context.pm.getAccountCreationPage().fillInCreateAccountForm(firstName, surname, password);
    }
    @When("^The user press register$")
    public void theUserPressRegister() {
        context.pm.getAccountCreationPage().clickRegisterButton();
    }
    @Then("^The user should see the account created$")
    public void theUserShouldSeeTheAccountCreated() {
        Assert.assertTrue(context.pm.getAccountCreationPage().isAccountCreationAlertDisplayed());
    }
}
