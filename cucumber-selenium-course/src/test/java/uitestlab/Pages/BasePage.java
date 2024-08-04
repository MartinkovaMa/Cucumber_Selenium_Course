package uitestlab.Pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uitestlab.Steps.TestContext;

import java.time.Duration;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestContext context;

    public BasePage(TestContext context) {
        this.driver = context.driver;
        this.context = context;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void clickWebElement(WebElement element) {
        try {
            clickWebElementAction(element);
        } catch (WebDriverException e) {
            throw new Error("Element click failed ...");
        }
    }

    protected void sendKeysToWebElement(WebElement element, String text) {
        try {
            sendKeysToWebElementAction(element, text);
        } catch (WebDriverException e) {
            throw new Error("sendKeys to element failed ...");
        }
    }

    private void sendKeysToWebElementAction(WebElement element, String text) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }


    private void clickWebElementAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void threadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumber() {
        Random rand = new Random();
        int r = rand.nextInt(1000000);
        return r;
    }

    public void showOnSecondScreen() {
        if (context.configProperties.getProperty("showOnSecondScreen").equals("true")) {
            Point point = new Point(-1000, 0);
            driver.manage().window().setPosition(point);
        }
    }
}
