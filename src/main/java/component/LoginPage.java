package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public By usernameBy = By.name("kullanici");	//kullanýcý adýnýn girildiði element
	public By passwordBy = By.name("sifre");		//þifrenin girildiði element
	public By signinBy = By.xpath("//input[@class='gg-m-24 gg-t-24 gg-d-24 gg-w-24 gg-ui-btn-primary gg-ui-btn-fluid  gg-ui-btn-lg']");	//giriþ yapmada kullanýlan buton
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Login metodu
	public void UserLogin(String userid,String pass) throws InterruptedException
	{
		driver.findElement(usernameBy).sendKeys(userid);
		Thread.sleep(6000);
		driver.findElement(passwordBy).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(signinBy).click();
	}

}
