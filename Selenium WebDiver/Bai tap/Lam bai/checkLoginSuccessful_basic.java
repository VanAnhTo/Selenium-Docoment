package TestSuite1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class checkLoginSuccessful_basic {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();		
		//driver.manage().window().maximize();
		baseUrl = "http://localhost/selenium-digitest";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void testAddContact() throws Exception {	
		
		driver.get(baseUrl + "/wp-login.php");		
		//driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("123456");
		driver.findElement(By.id("wp-submit")).click();		
		
	}
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
