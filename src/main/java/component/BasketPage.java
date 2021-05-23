package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
	
	WebDriver driver;
	public By amount = By.xpath("//select[@class='amount']");	//ürünün kaç adet olacaðýmý seçmede kullanýlan select box elementi
	public By twoUnit = By.xpath("//option[@value='2']");		//açýlan select box elementindeki 2 rakamý
	public By delete = By.xpath("//a[@title='Sil']");			//sepeti boþaltmada kullanýlan element
	
	public BasketPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//ürün adedi iki yapýlýr ve seçimin xpathde(selected value) belli olmasý için sayfa yenilenir
	public void AddUnit()
	{
		driver.findElement(amount).click();
		driver.findElement(twoUnit).click();
		driver.navigate().refresh();
	}
	
	//sepet boþaltýlýr
	public void drop() 
	{
		driver.findElement(delete).click();
	}
}