package org.example.automacaoMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DeviceFarmLogin {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeClass
    public static void caps() throws MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();

                // Set your access credentials
        caps.setCapability("browserstack.user", "patrickcustodio_vrS4cf");
        caps.setCapability("browserstack.key", "ByuzkkBCeox1nY7q9nsy");

                // Set URL of the application under test
        caps.setCapability("app", "bs://97ea5b07f7c54e611b49cf07e9dff57f0b67dbe6");

                // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

                // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");
                // Initialise the remote Webdriver using BrowserStack remote URL
                // and desired capabilities defined above
        driver = new AndroidDriver<RemoteWebElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);

                // Write your test case statements here
                // Invoke driver.quit() after the test is done to indicate that the test is completed.
        ScreenLogin = new ScreenLogin(driver);
    }



    @Test
    public void testeLogin(){
        ScreenLogin.logar();
    }
}
