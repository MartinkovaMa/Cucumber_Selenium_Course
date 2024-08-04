package uitestlab.Pages.Hotel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uitestlab.Pages.BasePage;
import uitestlab.Steps.TestContext;

public class HomePage extends BasePage {

    public HomePage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement signInLink;

    @FindBy(id = "user_info_acc")
    WebElement accountLink;

    @FindBy(xpath = "//a[@title='Log me out' and text()='Logout']")
    WebElement logoutOption;


    public void loadHomePage(){
        driver.get(context.configProperties.getProperty("hotelUrl"));
    }
    public void clickSignIn() {
        clickWebElement(signInLink);
    }

    public void loggedOut(){
        clickWebElement(accountLink);
        clickWebElement(logoutOption);
    }

}
