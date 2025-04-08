package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProduct {
	
	WebDriver driver;

    // Constructor to initialize PageFactory
    public RemoveProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeButton;
    
    
 // Find and remove the product from the cart
    public void removeProductFromCart(String productName) {
    	
        removeButton.click();
    }

    // Verify if product is removed from the cart
    public boolean isProductInCart(String productName) {
        try {
            driver.findElement(By.xpath("//div[text()='" + productName + "']"));
            return true; // Product is still in the cart
        } catch (Exception e) {
            return false; // Product not found in cart, meaning it was removed
        }
    }
    
   
}
