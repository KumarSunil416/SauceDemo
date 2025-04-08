package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import pages.CheckOut;


public class CheckOutTest extends BaseTest {
	@Test
    public void CheckOut() throws InterruptedException {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add a product to the cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        // Go to the cart
        inventoryPage.goToCart();

        CheckOut checkout = new CheckOut(driver);
        checkout.clickCheckOut();
        checkout.enterShippingDetails("Sunil","Kumar","7000");
        Thread.sleep(1000);
        
        checkout.finishCheckout();
        
        Assert.assertTrue(driver.getPageSource().contains("Thank you for your order!"), "Order not placed.");
    }
      
        
    }
	


