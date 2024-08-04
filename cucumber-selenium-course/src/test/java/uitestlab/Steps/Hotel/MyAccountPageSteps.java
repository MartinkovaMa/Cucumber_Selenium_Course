package uitestlab.Steps.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import uitestlab.Steps.TestContext;

public class MyAccountPageSteps {

    private final TestContext context;

    public MyAccountPageSteps(TestContext context) {
        this.context = context;
    }

    @Given("^The user clicked on my addresses option in the profile$")
    public void theUserClickedMyAddressesOptionInProfile() {
        context.pm.getMyAccountPage().clickMyAddressesButton();
    }

    @Given("^The user press add a new address$")
    public void theUserPressAddNewAddress() {
        context.pm.getMyAccountPage().clickAddNewAddress();
    }

}