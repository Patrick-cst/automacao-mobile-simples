package org.example.automacaoMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class ScreenLogin {

    public ScreenLogin(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "login_username")
    @iOSFindBy(xpath = "teste")
    private RemoteWebElement cmpEmail;

    @AndroidFindBy(id = "login_password")
    @iOSFindBy(xpath = "teste")
    private RemoteWebElement cmpSenha;

    @AndroidFindBy(id = "login_button")
    @iOSFindBy(xpath = "teste")
    private RemoteWebElement btnContinuar;

    public void logar(){
        cmpEmail.sendKeys("qazando@gmail.com");
        cmpSenha.sendKeys("1234");
        btnContinuar.click();
    }
}
