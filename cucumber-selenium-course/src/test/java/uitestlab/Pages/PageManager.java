package uitestlab.Pages;

import uitestlab.Pages.Hotel.*;
import uitestlab.Steps.TestContext;

public class PageManager {

    private final TestContext context;
    private BasePage basePage;

    private HomePage homePage;

    private LoginPage loginPage;
    private AccountCreationPage accountCreationPage;

    private MyAccountPage myAccountPage;

    private AddressPage addressPage;

    public PageManager(TestContext context) {
        this.context = context;
    }

    public BasePage getBasePage() {
        return (basePage == null) ? basePage = new BasePage(context) : basePage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(context) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(context) : loginPage;
    }

    public AccountCreationPage getAccountCreationPage() {
        return (accountCreationPage == null) ? accountCreationPage = new AccountCreationPage(context) : accountCreationPage;
    }

    public MyAccountPage getMyAccountPage() {
        return (myAccountPage == null) ? myAccountPage = new MyAccountPage(context) : myAccountPage;
    }

    public AddressPage getAddressPage() {
        return (addressPage == null) ? addressPage = new AddressPage(context) : addressPage;
    }

}
