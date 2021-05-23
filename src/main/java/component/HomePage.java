package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public By LoginHover = By.xpath("//div[text()='Giri� Yap']");				//fareyi �zerine getirdi�inizde login butonu ��kan element
	public By LoginButton = By.xpath("//a[@data-cy='header-login-button']");	//Login butonu
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		driver.get("https://www.gittigidiyor.com/");
		PageFactory.initElements(driver, this);
	}
	
	//ana sayfadan login sayfas�na ge�mede kullan�l�r
	public void gologin()
	{
		driver.findElement(LoginHover).click();
		driver.findElement(LoginButton).click();
	}
}
