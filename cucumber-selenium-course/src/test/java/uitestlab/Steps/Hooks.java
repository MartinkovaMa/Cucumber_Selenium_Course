package uitestlab.Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import uitestlab.Pages.PageManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before()
    public void beforeScenario() {
        loadConfigFile();
        ChromeOptions options = new ChromeOptions();
        if (context.configProperties.getProperty("isHeadless").equals("true")){
            options.addArguments("--headless=new");
        }
        context.driver = new ChromeDriver(options);
        context.pm = new PageManager(context);
        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        context.pm.getBasePage().showOnSecondScreen();
        context.driver.manage().window().maximize();
    }

    @After()
    public void afterScenario() {
        context.driver.quit();
    }

    private void loadConfigFile() {
        Properties configProperties;
        try (InputStream input = new FileInputStream("src/test/java/uitestlab/Configs/courseConfig.properties")) {
            configProperties = new Properties();
            configProperties.load(input);
        } catch (IOException ex) {
            throw new Error("Config file not found ...");
        }
        context.configProperties = configProperties;
    }
}
