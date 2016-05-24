package TestSuite1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class checkInvalidPassword {
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
	public void testcheckInvalidPassword() throws Exception {	
		
		driver.get(baseUrl);		
		driver.findElement(By.xpath(".//*[@id='meta-2']/ul/li[2]/a")).click();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("123");
		driver.findElement(By.id("wp-submit")).click();
		
		String expectedMessageLogin = "Welcome to WordPress!ERROR: The password you entered for the username admin is incorrect.";
		String actuanMessageLogin = driver.findElement(By.xpath(".//*[@id='login_error']")).getText();
		if(actuanMessageLogin.contentEquals(expectedMessageLogin))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
