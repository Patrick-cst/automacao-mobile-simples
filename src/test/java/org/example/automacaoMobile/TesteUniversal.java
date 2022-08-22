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

public class TesteUniversal {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    public static String local = "";
    public static String plataforma = "";

    @BeforeClass
    public static void caps() throws MalformedURLException {

        local = System.getProperty("local").toLowerCase();
        plataforma = System.getProperty("plataforma").toLowerCase();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (local.equals("local") && plataforma.equals("android")){
            capabilities.setCapability("app", new File("apps/app-debug.apk"));
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "10");
            capabilities.setCapability("unicodeKeyboard", true);

            driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
            ScreenLogin = new ScreenLogin(driver);
        }else {
            capabilities.setCapability("app", new File("apps/LoginExample.app"));
            capabilities.setCapability("deviceName", "iphone13");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "15.1");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("unicodeKeyboard", true);

            driver = new IOSDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
            ScreenLogin = new ScreenLogin(driver);
        }


    }

    @Test
    public void testeLogin(){
        ScreenLogin.logar();
    }
}
