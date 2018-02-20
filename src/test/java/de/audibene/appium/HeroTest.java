package de.audibene.appium;

import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import com.microsoft.appcenter.appium.Factory;
import org.junit.rules.TestWatcher;

public class HeroTest {
    private EnhancedIOSDriver driver;

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appiumVersion", "1.7.1");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("Full_reset", "true");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("deviceName", "OiPhone");
        caps.setCapability("platformVersion", "11.2");
        caps.setCapability("app", "/Users/oleg.butov/Downloads/earaDist.ipa");
        caps.setCapability("udid", "ce1c4c7e6e9ae58460bf8e5a29cb6061a5a4ba67");
        caps.setCapability("xcodeOrgId", "8422K99N9E");


        driver =  Factory.createIOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

    @After
    public void TearDown(){
        driver.label("Stopping App");
        driver.quit();
    }

    @Test
    public void CheckLetsGetStartedIsPresent() throws Exception {
        driver.label("Looking to get started");
        Assert.assertTrue(driver.findElement(By.name("Lets get started")).isDisplayed());
    }

    @Test
    public void CheckChatButtonIsPresent() throws Exception {
        driver.findElement(By.name("Lets get started")).click();
        Assert.assertTrue(driver.findElement(By.name("Chat Button")).isDisplayed());
        driver.label("Found chat button");
    }

}

