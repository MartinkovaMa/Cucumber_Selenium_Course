package uitestlab.Pages.Hotel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uitestlab.Pages.BasePage;
import uitestlab.Steps.TestContext;

public class MyAccountPage extends BasePage {
    public MyAccountPage(TestContext context){
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//a[@title='Addresses' and contains(.,'My addresses')]")
    WebElement myAddressButton;

    @FindBy(xpath = "//a[@title='Add an address' and contains(.,'Add a new address')]")
    WebElement addNewAddressButton;


    public void clickMyAddressesButton(){
        clickWebElement(myAddressButton);
    }

    public void clickAddNewAddress(){
        clickWebElement(addNewAddressButton);
    }
}
