package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
	
	WebDriver driver;
	public By addbasket = By.xpath("//button[@id='add-to-basket']");	//sepete ekle butonu
	public By basketpage = By.xpath("//a[text()='Sepete Git']");		//sepet sayfasýna giden buton
	
	public ItemPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//ürünü sepete ekler
	public void addbasket()
	{
		driver.findElement(addbasket).click();
	}
	
	//sepet sayfasýna gider
	public void gobasketpage() 
	{
		driver.findElement(basketpage).click();
	}
}
