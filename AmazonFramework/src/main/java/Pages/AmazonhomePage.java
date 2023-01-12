package Pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonhomePage {
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement SearchBtn ;
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement SearchField ;
	
	@FindBy (xpath = "(//div[@data-component-type='s-search-result']//a)[5]")
	private WebElement FirstResult ;
	
	@FindBy (xpath = "//a[@id='nav-cart']")
	private WebElement Cart ;
	
	@FindBy (xpath = "//span[@id='attach-sidesheet-view-cart-button']")
	private WebElement SideCartBtn ;

	@FindBy (id = "add-to-cart-button")
	private WebElement AddtoCartBtn ;
	
	@FindBy (xpath = "//form//a//span//span//span[1]")
	private WebElement ProductName;
	
	@FindBy (xpath = "//span[@id='nav-cart-count']")
	private WebElement CartCount;
	
	@FindBy (xpath = "//input[@value='Delete']")
	private WebElement DeleteLink;
	
	@FindBy (xpath = "//span[text()='Account & Lists']")
     WebElement AccountListbtn ;
	
	@FindBy (xpath = "//span[text()='Your Account']")
	private WebElement YourAccount;
	
	@FindBy (xpath = "//span[text()='Your Orders']")
	private WebElement YourOrders;

	
	public AmazonhomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void productSearch(String ProductName ) {
		
		SearchField.sendKeys(ProductName);
		SearchBtn.click();
	}
	
	public void clickonProduct() {
		FirstResult.click();
	}
	
	public void switchtonewtab(WebDriver driver, int number) {
	
		ArrayList<String> List = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(List.get(number));
		String Title = driver.getTitle();
		System.out.println(Title);
	}
	
	public void clickonAddtoCartBtn() {
		AddtoCartBtn.click();
	}
	
	public void clickonCart() {
		Cart.click();
	}	
	
	public void clickonSideCart() {
		SideCartBtn.click();
	}	
	
	public void getCartCount() {
		String count = CartCount.getText();
		System.out.println("Cart Count"+" "+ count);
	}	
	
	public void getProductName() {
		String Name = ProductName.getText();
		System.out.println(Name);
	}
	
	public void deletefromCart() {
		DeleteLink.click();
		System.out.println("Cart Count after Delete");
	}
	
	public void mouseover(WebDriver driver) {
		Actions b = new Actions(driver);
		b.moveToElement(AccountListbtn).perform();
	 }
	 
	public void clickonAccountlink() {
		AccountListbtn.click();
	 }
	 
	public void clickonYourOrders() {
		YourOrders.click();
	 }
}
