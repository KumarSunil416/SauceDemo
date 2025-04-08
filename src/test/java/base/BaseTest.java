package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;

    @BeforeMethod
    public void setup() {
        
        
     // Automatically download and set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
         driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.saucedemo.com/");;

        // Print the title of the page
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
