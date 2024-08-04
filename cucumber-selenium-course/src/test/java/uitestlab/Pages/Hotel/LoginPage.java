package uitestlab.Pages.Hotel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uitestlab.Pages.BasePage;
import uitestlab.Steps.TestContext;

public class LoginPage extends BasePage {

    public LoginPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(id = "SubmitCreate")
    WebElement createButton;

    @FindBy(id = "email_create")
    WebElement emailInput;

    @FindBy(id = "email")
    WebElement emailLoginInput;

    @FindBy(id = "passwd")
    WebElement passwordLoginInput;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;

    public void inputEmail(String email) {
        sendKeysToWebElement(emailInput, email);
    }

    public void clickCreateAccount() {
        clickWebElement(createButton);
    }

    public void loginIntoSystem() {
        sendKeysToWebElement(emailLoginInput, context.email);
        sendKeysToWebElement(passwordLoginInput, "1234567");
        clickWebElement(submitLoginButton);
    }

    public void loginIntoSystem(String email, String passwd) {
        sendKeysToWebElement(emailLoginInput, email);
        sendKeysToWebElement(passwordLoginInput, passwd);
        clickWebElement(submitLoginButton);
    }

}
