package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import component.BasketPage;
import component.HomePage;
import component.ItemPage;
import component.LoginPage;
import component.SearchPage;

public class ApplyTest {
	
	WebDriver driver;
	final static Logger logger = LogManager.getLogger(ApplyTest.class);
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Test() throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		String URL = driver.getCurrentUrl();
		assertEquals(URL,"https://www.gittigidiyor.com/");		//ana sayfa m� kontrol edilir
		logger.info("Site a��ld� ve ana sayfa kontrol edildi.");
		
		home.gologin();
		Thread.sleep(2000);
		
		LoginPage login = new LoginPage(driver);
		login.UserLogin("berataslan_38@hotmail.com.tr", "5327324366");
		String UserName = driver.findElement(By.xpath("//span[text()='berataslann']")).getText();
		assertNotEquals(UserName,"veya �ye Ol");		//giri� yap�ld� m� kontrol edilir
		logger.info("Siteye Login olundu ve kontrol edildi.");
		
		SearchPage search = new SearchPage(driver);
		search.searchItem("Bilgisayar");	
		String Page = driver.findElement(By.xpath("//li[@class='selected']")).getText();
		assertEquals(Page,"2");		//2. sayfa a��ld� m� kontrol edilir
		logger.info("Bilgisayar kelimesi girildi, 2. sayfa a��ld� ve kontrol edildi.");
		Thread.sleep(2000);
		
		search.additem();
		String ItemPrice = driver.findElement(By.xpath("//div[@id='sp-price-lowPrice']")).getText();
		Thread.sleep(2000);
		
		ItemPage item = new ItemPage(driver);
		item.addbasket();
		Thread.sleep(2000);

		item.gobasketpage();
		String BasketPrice = driver.findElement(By.xpath("//div[@class='total-price']")).getText();
		assertEquals(ItemPrice,BasketPrice);		//�r�n fiyat� ile sepet fiyat� ayn� m� kontrol edilir
		logger.info("Se�ilen �r�n ile sepetteki �r�n fiyat� ayn�");	
		Thread.sleep(2000);
		
		BasketPage basketpage = new BasketPage(driver);
		basketpage.AddUnit();
		String unit = driver.findElement(By.xpath("//option[@selected='']")).getText();
		assertEquals(unit,"2");		//�r�n adedi kar��la�t�r�l�r
		logger.info("Adet artt�r�ld� ve 2 oldu�u do�ruland�.");
		Thread.sleep(2000);

		basketpage.drop();
		String ItemCount = driver.findElement(By.xpath("//span[@id='cart-items-count']")).getText();
		assertEquals(ItemCount,"");		//sepette �r�n adedinin bo� olup olmad��� kontrol edildi
		logger.info("�r�nler sepetten silindi");
		Thread.sleep(4000);
	}
	
	@After
	public void close ()
	{
		driver.close();
	}
}
