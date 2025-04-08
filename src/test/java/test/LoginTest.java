package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);  // Page Object class
        loginPage.login("standard_user", "secret_sauce");

        // Assertion to verify successful login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or redirected to wrong page.");
    }
}
