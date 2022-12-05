package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	//For Chrome Browser
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajan\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	//For Firefox Browser
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajan\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver ();
		return driver;
	}
	//For Edge Browser
	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\rajan\\Desktop\\Drivers\\msedgedriver.exe");
		WebDriver driver= new EdgeDriver ();
		return driver;
	}
}
