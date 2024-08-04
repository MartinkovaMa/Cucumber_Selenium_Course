package uitestlab.Pages.Hotel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uitestlab.Pages.BasePage;
import uitestlab.Steps.TestContext;

public class AccountCreationPage extends BasePage {
    public AccountCreationPage(TestContext context){
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(id="customer_firstname")
    WebElement firstNameInput;

    @FindBy(id="customer_lastname")
    WebElement lastNameInput;

    @FindBy(id="passwd")
    WebElement passwordInput;

    @FindBy(id="submitAccount")
    WebElement registerButton;

    @FindBy(xpath="//p[contains(text(),'Your account has been created.')]")
    WebElement accountCreationConformationAlert;


    public void fillInCreateAccountForm(String firstName, String lastName, String password){
        sendKeysToWebElement(firstNameInput, firstName);
        sendKeysToWebElement(lastNameInput, lastName);
        sendKeysToWebElement(passwordInput, password);
    }

    public void clickRegisterButton(){
        clickWebElement(registerButton);
    }

    public boolean isAccountCreationAlertDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(accountCreationConformationAlert));
        return accountCreationConformationAlert.isDisplayed();
    }
}
