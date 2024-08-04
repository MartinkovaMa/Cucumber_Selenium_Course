package uitestlab.Pages.Hotel;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uitestlab.Pages.BasePage;
import uitestlab.Steps.TestContext;

import java.util.List;

public class AddressPage extends BasePage {
    public AddressPage(TestContext context){
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//a[@title='Addresses' and contains(.,'My addresses')]")
    WebElement myAddressButton;

    @FindBy(id= "address1")
    WebElement address1Input;

    @FindBy(id= "postcode")
    WebElement zipCodeInput;

    @FindBy(id= "city")
    WebElement cityInput;

    @FindBy(id= "phone")
    WebElement phoneInput;

    @FindBy(id= "submitAddress")
    WebElement submitButton;

    @FindBy(xpath= "//div[@class='col-xs-12 col-sm-12 address']")
    List<WebElement> addressList;

    @FindBy(xpath= "//span[@class='address_name']")
    List<WebElement> addressNames;


    public void fillDetailsIntoNewAddress(){
        sendKeysToWebElement(address1Input,"123 Home Street");
        sendKeysToWebElement(zipCodeInput,"12345");
        sendKeysToWebElement(cityInput,"Krakow");
        sendKeysToWebElement(phoneInput,"999999999");
    };

    public void clickSaveButton(){
        clickWebElement(submitButton);
    }

    public void validateNewAddress(){
        wait.until(ExpectedConditions.visibilityOf(addressList.get(addressList.size()-1)));
        Assert.assertEquals("Count of addresses failed ...", addressList.size(),1);
        Assert.assertEquals("Count of address titles failed ...", addressNames.size(),2);
        Assert.assertEquals("First address name failed ..." ,addressNames.get(0).getText(),"Test");
        Assert.assertEquals("Second address name failed ...", addressNames.get(1).getText(),"User");
    }
}
