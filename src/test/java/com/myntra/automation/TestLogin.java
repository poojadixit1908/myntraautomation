package com.myntra.automation;

import com.myntra.automation.pageobjects.LoginPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Pooja\\software\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.myntra.com/");
    }

    @Test
    public void test_login_functionality_is_working() throws InterruptedException {
        //login using LoginPage object
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.login("poojadixit1908@gmail.com", "1P@ssw0rd");
        //verify that the correct user has been logged in
        String currentLoggedInUser = loginPage.getCurrentLoggedInUser();
        Assert.assertEquals("Invalid user logged in", "poojadixit1908@gmail.com", currentLoggedInUser);
    }


}
