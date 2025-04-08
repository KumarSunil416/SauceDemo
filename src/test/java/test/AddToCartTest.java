package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {
	
	 @Test
	    public void testAddProductToCart() {
	        // Login
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("standard_user", "secret_sauce");

	        // Add a product to the cart
	        InventoryPage inventoryPage = new InventoryPage(driver);
	        inventoryPage.addProductToCart("Sauce Labs Backpack");

	        // Go to the cart
	        inventoryPage.goToCart();

	        // Validate that the product is in the cart
	        Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"), "Product was not added to the cart.");
	    }

}
