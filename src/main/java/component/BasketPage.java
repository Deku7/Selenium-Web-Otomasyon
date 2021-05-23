package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
	
	WebDriver driver;
	public By amount = By.xpath("//select[@class='amount']");	//�r�n�n ka� adet olaca��m� se�mede kullan�lan select box elementi
	public By twoUnit = By.xpath("//option[@value='2']");		//a��lan select box elementindeki 2 rakam�
	public By delete = By.xpath("//a[@title='Sil']");			//sepeti bo�altmada kullan�lan element
	
	public BasketPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//�r�n adedi iki yap�l�r ve se�imin xpathde(selected value) belli olmas� i�in sayfa yenilenir
	public void AddUnit()
	{
		driver.findElement(amount).click();
		driver.findElement(twoUnit).click();
		driver.navigate().refresh();
	}
	
	//sepet bo�alt�l�r
	public void drop() 
	{
		driver.findElement(delete).click();
	}
}