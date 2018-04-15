package com.myntra.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        //find the div just before the login button
        WebElement loginDivElement = driver.findElement(By.cssSelector(".desktop-getUserInLinks.desktop-getInLinks"));
        List<WebElement> anchorElements = loginDivElement.findElements(By.tagName("a"));
        //click on a element which is of type login
        /**
        for (WebElement anchorElement : anchorElements) {
            String value = anchorElement.getAttribute("data-track");
            if ("login".equals(value)) {
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", anchorElement);
                anchorElement.click();
                break;
            }
        }**/
        driver.get("https://www.myntra.com/login");
    }

    public void login(String username, String password) {
        WebElement emailElement = driver.findElement(By.cssSelector(".login-user-input-email.login-user-input"));
        WebElement passwordElement = driver.findElement(By.cssSelector(".login-user-input-password.login-user-input"));
        emailElement.sendKeys(username);
        passwordElement.sendKeys(password);
        WebElement loginButtonElement = driver.findElement(By.className("login-login-button"));
        loginButtonElement.click();
    }

    public String getCurrentLoggedInUser() {
        WebElement infoEmailDiv = driver.findElement(By.className("desktop-infoEmail"));
        String loggedInUserEmail = infoEmailDiv.getText();
        return loggedInUserEmail;
    }


}
