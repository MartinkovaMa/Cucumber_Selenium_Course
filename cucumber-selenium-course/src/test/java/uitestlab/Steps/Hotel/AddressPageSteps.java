package uitestlab.Steps.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uitestlab.Steps.TestContext;

public class AddressPageSteps {

    private final TestContext context;

    public AddressPageSteps(TestContext context) {
        this.context = context;
    }

    @When("^The user fills in the new address details into the form$")
    public void theUserFillsInTheNewAddressIntoTheForm() {
        context.pm.getAddressPage().fillDetailsIntoNewAddress();
    }

    @When("^The user save the new address form$")
    public void theUserSaveNewAddressForm() {
        context.pm.getAddressPage().clickSaveButton();
    }

    @Then("^The user should see new address added to the list$")
    public void theUserShouldSeeNewAddressAddedToList() {
        context.pm.getAddressPage().validateNewAddress();
    }
}