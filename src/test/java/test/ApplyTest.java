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
		assertEquals(URL,"https://www.gittigidiyor.com/");		//ana sayfa mý kontrol edilir
		logger.info("Site açýldý ve ana sayfa kontrol edildi.");
		
		home.gologin();
		Thread.sleep(2000);
		
		LoginPage login = new LoginPage(driver);
		login.UserLogin("berataslan_38@hotmail.com.tr", "5327324366");
		String UserName = driver.findElement(By.xpath("//span[text()='berataslann']")).getText();
		assertNotEquals(UserName,"veya Üye Ol");		//giriþ yapýldý mý kontrol edilir
		logger.info("Siteye Login olundu ve kontrol edildi.");
		
		SearchPage search = new SearchPage(driver);
		search.searchItem("Bilgisayar");	
		String Page = driver.findElement(By.xpath("//li[@class='selected']")).getText();
		assertEquals(Page,"2");		//2. sayfa açýldý mý kontrol edilir
		logger.info("Bilgisayar kelimesi girildi, 2. sayfa açýldý ve kontrol edildi.");
		Thread.sleep(2000);
		
		search.additem();
		String ItemPrice = driver.findElement(By.xpath("//div[@id='sp-price-lowPrice']")).getText();
		Thread.sleep(2000);
		
		ItemPage item = new ItemPage(driver);
		item.addbasket();
		Thread.sleep(2000);

		item.gobasketpage();
		String BasketPrice = driver.findElement(By.xpath("//div[@class='total-price']")).getText();
		assertEquals(ItemPrice,BasketPrice);		//ürün fiyatý ile sepet fiyatý ayný mý kontrol edilir
		logger.info("Seçilen ürün ile sepetteki ürün fiyatý ayný");	
		Thread.sleep(2000);
		
		BasketPage basketpage = new BasketPage(driver);
		basketpage.AddUnit();
		String unit = driver.findElement(By.xpath("//option[@selected='']")).getText();
		assertEquals(unit,"2");		//ürün adedi karþýlaþtýrýlýr
		logger.info("Adet arttýrýldý ve 2 olduðu doðrulandý.");
		Thread.sleep(2000);

		basketpage.drop();
		String ItemCount = driver.findElement(By.xpath("//span[@id='cart-items-count']")).getText();
		assertEquals(ItemCount,"");		//sepette ürün adedinin boþ olup olmadýðý kontrol edildi
		logger.info("Ürünler sepetten silindi");
		Thread.sleep(4000);
	}
	
	@After
	public void close ()
	{
		driver.close();
	}
}
