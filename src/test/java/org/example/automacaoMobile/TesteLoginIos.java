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

public class TesteLoginIos {

    private static ScreenLogin ScreenLogin;
    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeClass
    public static void caps() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Caminho do APK
        capabilities.setCapability("app", new File("apps/LoginExample.app"));
        //digitar ADB DEVICES no terminal e colocar o nome que o sistema tras no value.
        capabilities.setCapability("deviceName", "iphone13");
        //Inserir no value a plataforma android ou ios
        capabilities.setCapability("platformName", "iOS");
        //versao do ios
        capabilities.setCapability("platformVersion", "15.1");
        //para intepretar os comandos do xcuitest
        capabilities.setCapability("automationName", "XCUITest");
        //Ajuda a tirar o bug do teclado
        capabilities.setCapability("unicodeKeyboard", true);
        //sincronizacao entre android driver e url da porta do appium
        driver = new IOSDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

        ScreenLogin = new ScreenLogin(driver);
    }

    @Test
    public void testeLogin(){
        ScreenLogin.logar();
    }
}
