package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class sortProductsHighToLow extends BaseTest {
	
	@Test
	public void testSortByPriceLowToHigh() throws InterruptedException {
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.login("standard_user", "secret_sauce");
	
	InventoryPage inventorypage = new InventoryPage(driver);
	inventorypage.sortHighToLow();
	Thread.sleep(3000);
	List<Double> prices = inventorypage.getProductPrices();
	boolean isSorted = inventorypage.isSortedHighToLow(prices);
	
	
	Assert.assertTrue(isSorted, "Products are not sorted by price (High To Low)");
	
			
	
	}

}
