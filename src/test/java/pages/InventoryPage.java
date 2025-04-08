package pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
	WebDriver driver;

    // Constructor to initialize PageFactory
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement product;
    
    @FindBy(id = "shopping_cart_container")
    WebElement cart;
    
 // Sort dropdown
    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    // Product prices
    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;

    // Web elements for product actions
    public void addProductToCart(String productName) {
        product.click();
    }

    public void goToCart() {
        
        cart.click();
    }
    
 // Select sort option
    public void sortLowToHigh() {
    	Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText("Price (low to high)");
    }
    
    public void sortHighToLow() {
    	Select dropdown = new Select(sortDropdown);
    	dropdown.selectByVisibleText("Price (high to low)");
    }
    
 // Get list of prices from UI
    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }
    
    public boolean isSortedLowToHigh(List<Double> prices) {
        List<Double> sortedList = new ArrayList<>(prices);
        Collections.sort(sortedList);
        return prices.equals(sortedList);
        
    }
    
    public boolean isSortedHighToLow(List<Double> prices) {
        List<Double> sortedList = new ArrayList<>(prices);
        sortedList.sort(Collections.reverseOrder());
        return prices.equals(sortedList);
        
    }
    
    
}


