 package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.AmazonhomePage;
import browserSetup.Base;
import utils.Utility;

public class TestYourAccountandOrders extends Base {
	WebDriver driver;
	AmazonhomePage amzpage;
	SoftAssert soft;
	
		@Parameters ("Browser")
	
		@BeforeTest
		public void launchBrowser(String browserName) {
 
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		
		}
	
		if(browserName.equals("Edge"))
		{
			driver= openEdgeBrowser();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@BeforeClass
	
		public void createPOMObjects() {
		amzpage = new AmazonhomePage(driver);
		soft = new SoftAssert();
		}
	
	
		@BeforeMethod 
		public void openAmazonURL()  {
		driver.get("https://www.amazon.in/");
		amzpage.mouseover(driver);
		}
	
		@Test (priority = 1 )
		public void  verifyYourAccount  () throws InterruptedException {
			
			amzpage.clickonAccountlink();
			Thread.sleep(2000);
			
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Amazon Sign In", "Title Name of YourAccountPage");
			soft.assertAll();
		}
	    
		@Test(priority = 2 )   
		public void  verifyYourOrders() throws InterruptedException {
			amzpage.clickonYourOrders();
			
			Thread.sleep(2000);
			
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Amazon Sign In", "Title Name of YourOrdersPage");
			
			driver.navigate().back();
			String mainpage = driver.getTitle();
			System.out.println(mainpage);
			soft.assertAll();
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
		public void clearObject() {
			amzpage = null ;
			soft = null ;
		}
		
		@AfterTest
		public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.gc();
	}

}
