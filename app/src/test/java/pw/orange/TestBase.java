/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pw.orange;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;


public class TestBase {

    static AppiumDriver<MobileElement> driver;

    @BeforeClass
    static public void setup(){

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "7.1.1");
            capabilities.setCapability("deviceName", "android emulator");
            capabilities.setCapability("appPackage", "com.citynav.jakdojade.pl.android");
            capabilities.setCapability("appActivity", "com.citynav.jakdojade.pl.android.main.MainActivity");
            capabilities.setCapability("automationName", "UiAutomator2");

            URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(serverURL, capabilities);

            System.out.println("\nStarting...");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    static public void teardown(){
        System.out.println("\nTests finished...");
        driver.quit();
    }
}