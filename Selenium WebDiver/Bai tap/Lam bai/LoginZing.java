package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginZing {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl ="https://id.zing.vn";
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testLoginZing() throws Exception
	{
		driver.get(baseUrl);
		driver.findElement(By.id("login_account")).sendKeys("vananhto112233");
		driver.findElement(By.id("login_pwd")).sendKeys("123321");
		driver.findElement(By.className("zidsignin_btn")).click();
		
	}
	
	public void tearDown()
	{
		driver.quit();
	}
}
