package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Pages.AmazonhomePage;
import browserSetup.Base;
import utils.Utility;

public class TestCart extends Base {
		WebDriver driver;
		AmazonhomePage amzpage;
		
		@Parameters ("Browser")
		
		@BeforeTest
		public void launchBrowser(String browserName) {
			 
			if(browserName.equals("Chrome"))
			{
				driver = openChromeBrowser();
			}
		
			if(browserName.equals("Edge"))
			{
				driver= openEdgeBrowser();
			}
			
			if(browserName.equals("Firefox"))
			{
				driver = openFirefoxBrowser();
			
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	
		@BeforeClass
		public void createPOMObjects() {
			amzpage = new AmazonhomePage(driver);
		}
	
		@BeforeMethod 
		public void openAmazonURL() {
			driver.get("https://www.amazon.in/");
		}
	
		@Test (priority = 1)
		public void AddtoCart() throws InterruptedException {
			amzpage.getCartCount();
			amzpage.productSearch(Utility.getDatafromExcel(2, 0));
			amzpage.clickonProduct();
			amzpage.switchtonewtab(driver, 1);
			Thread.sleep(3000);
			amzpage.clickonAddtoCartBtn();
			Thread.sleep(3000);
			amzpage.clickonSideCart();
			amzpage.getCartCount();
			amzpage.getProductName();
		}
	
		@Test (priority = 2, dependsOnMethods = "AddtoCart" )
		public void RemoveFromCart() {
			amzpage.getCartCount();
			amzpage.clickonCart();
			amzpage.deletefromCart();
			amzpage.getCartCount();
		}
	    
		@AfterMethod 
		public void screenShot(ITestResult result){
			//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
			if(ITestResult.FAILURE==result.getStatus()){
				Utility.captureScreenShot(result.getName(), driver);
			}
			else {
				System.out.println("Test Case is Pass");
			}
			
		}
		
		@AfterClass
		public void clearObject(){
			System.out.println("After Class");
			amzpage = null;
		}
		
		@AfterTest
		public void afterTest() throws InterruptedException {
			Thread.sleep(2000);
			driver.close();
			driver.quit();
			System.gc();
		}
}
