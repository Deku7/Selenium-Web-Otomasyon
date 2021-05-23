package component;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	WebElement myelement;
	public By searchtext = By.name("k");											//arama kutusunun bulunduðu element
	public By searchbutton = By.xpath("//span[text()='BUL']");						//arama butonu
	public By secendpagebutton = By.xpath("//a[text()='2']");						//2. sayfaya geçmede kullanýlan element
	public By selecteditem = By.xpath("//div[@id='item-info-block-576239506']");	//ürün elementi
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//gönderilen ürün adýný girerek arama yapar ve ikinci sayfaya gider
	public void searchItem(String product)
	{
		driver.findElement(searchtext).sendKeys(product);
		driver.findElement(searchbutton).click();
		myelement = driver.findElement(By.xpath("//a[text()='2']"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement);
		driver.findElement(secendpagebutton).click();
	}
	
	//ürünü seçer
	public void additem()
	{
		myelement = driver.findElement(By.xpath("//div[@id='item-info-block-576239506']"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement);
		driver.findElement(selecteditem).click();
	}
}
