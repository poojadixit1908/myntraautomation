package com.myntra.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageWithPageFactory {

    private WebDriver driver;

    @FindBy(css = ".login-user-input-email.login-user-input")
    WebElement emailElement;

    @FindBy(css = ".login-user-input-password.login-user-input")
    WebElement passwordElement;

    @FindBy(css = "")
    WebElement loginButtonElement;

    public LoginPageWithPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        emailElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

}x
