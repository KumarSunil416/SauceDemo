package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import pages.RemoveProduct;

public class RemoveProductFromCart extends BaseTest {
	
	@Test
	public void RemoveProductFromCart() throws InterruptedException  {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("standard_user", "secret_sauce");
		
		InventoryPage addProduct = new InventoryPage(driver);
		addProduct.addProductToCart("Sauce Labs Backpack");
		addProduct.goToCart();
		
		
		RemoveProduct remProduct = new RemoveProduct(driver);
		remProduct.removeProductFromCart("Sauce Labs Backpack");
		Thread.sleep(3000);
		
		Assert.assertFalse(remProduct.isProductInCart("Sauce Labs Backpack"), "Product was not removed from the cart.");
		
		
		
	}
	

}
