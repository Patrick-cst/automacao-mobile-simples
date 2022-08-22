package org.example.automacaoMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TesteLoginAndroid {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeClass
    public static void caps() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Caminho do APK
        capabilities.setCapability("app", new File("apps/app-debug.apk"));
        //digitar ADB DEVICES no terminal e colocar o nome que o sistema tras no value.
        capabilities.setCapability("deviceName", "emulator-5554");
        //Inserir no value a plataforma android ou ios
        capabilities.setCapability("platformName", "Android");
        //versao
        capabilities.setCapability("platformVersion", "10");
        //Ajuda a tirar o bug do teclado
        capabilities.setCapability("unicodeKeyboard", true);
        //sincronizacao entre android driver e url da porta do appium
        driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        ScreenLogin = new ScreenLogin(driver);
    }

    @AfterClass
    public static void after(){
        driver.quit();

    }

    @Test
    public void testeLogin(){
        ScreenLogin.logar();
    }
}
