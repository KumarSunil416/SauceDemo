package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

	WebDriver driver;

    // Constructor to initialize PageFactory
    public CheckOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "checkout")
    WebElement btnCheckOut;
    
    @FindBy(id = "first-name")
    WebElement fName;
    
    @FindBy(id = "last-name")
    WebElement lName;
    
    @FindBy(id = "postal-code")
    WebElement zCode;
    
    @FindBy(id = "continue")
    WebElement btnContinue;
    
    @FindBy(id = "finish")
    WebElement btnFinish;
    
    @FindBy(className = "complete-header")
    WebElement completeMsg;
    
   public void clickCheckOut() {
	   btnCheckOut.click();
   } 
   
   public void enterFirstName(String firstName) {
       fName.sendKeys(firstName);
   }

   public void enterLastName(String lastName) {
       lName.sendKeys(lastName);
   }

   public void enterZipCode(String zipCode) {
       zCode.sendKeys(zipCode);
   }
   public void clickContinue() {
       btnContinue.click();
   }
   
   public void enterShippingDetails(String Fname,String Lname, String zipcode) {
	   enterFirstName(Fname);
	   enterLastName(Lname);
	   enterZipCode(zipcode);
	   clickContinue();
   }
   
   public void finishCheckout() {
       btnFinish.click();
   }
   
   public void isCheckoutComplete() {

       completeMsg.getText().contains("THANK YOU FOR YOUR O");
   }
   
    

}