package uitestlab.Steps.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import uitestlab.Steps.TestContext;


public class HomePageSteps {

    private final TestContext context;

    public HomePageSteps(TestContext context){
        this.context = context;
    }

    @Given("^The user loaded the hotel main page$")
    public void  theUserLoadedTheHotelMainPage(){
        context.pm.getHomePage().loadHomePage();
    }

    @Given("^The user logged out the hotel system$")
    public void theUserLoggedOutHotelSystem(){
        context.pm.getHomePage().loggedOut();
    }


    @Given("^The user logged in the hotel system$")
    public void theUserLoggedInHotelSystem(){
        context.pm.getHomePage().clickSignIn();
        context.pm.getLoginPage().loginIntoSystem();
    }


    @When("^The user clicks Sign in button$")
    public void theUserClicksSignInButton() {
        context.pm.getHomePage().clickSignIn();
    }

}
