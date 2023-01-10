package browserSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public String baseURL="https://www.amazon.in/";
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	//For Firefox Browser
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		WebDriver driver= new FirefoxDriver ();
		return driver;
	}
	//For Edge Browser
	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
		WebDriver driver= new EdgeDriver ();
		return driver;
	}
	
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
