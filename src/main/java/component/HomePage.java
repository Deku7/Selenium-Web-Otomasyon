package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public By LoginHover = By.xpath("//div[text()='Giriþ Yap']");				//fareyi üzerine getirdiðinizde login butonu çýkan element
	public By LoginButton = By.xpath("//a[@data-cy='header-login-button']");	//Login butonu
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		driver.get("https://www.gittigidiyor.com/");
		PageFactory.initElements(driver, this);
	}
	
	//ana sayfadan login sayfasýna geçmede kullanýlýr
	public void gologin()
	{
		driver.findElement(LoginHover).click();
		driver.findElement(LoginButton).click();
	}
}
