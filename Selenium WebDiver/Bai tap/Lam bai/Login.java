package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception{
		driver  = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl  = "http://10.61.68.32:8080/thongtinthuoc/index.zul";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	} 
	
	@Test
	public void testLogin() throws Exception{
		driver.get(baseUrl);
		//driver.findElement(By.id("")).sendKeys("123456");
		
	}
	
	@After
	public void teatDown() throws Exception{
		driver.quit();
	}
	
	
}
