package uitestlab.Steps.Hotel;

import io.cucumber.java.en.When;
import uitestlab.Steps.TestContext;

public class LoginPageSteps {

    private final TestContext context;

    public LoginPageSteps(TestContext context) {
        this.context = context;
    }

    @When("^The user entered his email and password")
    public void theUserEnteredHisEmailAndPassword() {
        String userEmail = context.configProperties.getProperty("hotelUserEmail");
        String userPassword = context.configProperties.getProperty("hotelUserPassword");
        context.pm.getLoginPage().loginIntoSystem(userEmail, userPassword);
    }

    @When("^The user fills in email and selects Create an account$")
    public void theUserFillsInEmailAndSelectsCreteAnAccount() {
        context.email = "test" + context.pm.getBasePage().getRandomNumber() + "@test.com";
        context.pm.getLoginPage().inputEmail(context.email);
        context.pm.getLoginPage().clickCreateAccount();
    }

}
