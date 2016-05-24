package TestSuite1;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class checkLoginSuccessful {
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
	public void testCheckLoginSuccessful() throws Exception {	
		
		driver.get(baseUrl);		
		driver.findElement(By.xpath(".//*[@id='meta-2']/ul/li[2]/a")).click();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("123456");
		driver.findElement(By.id("wp-submit")).click();
		
		String expectedMessageLogin = "Welcome to WordPress!";
		String actuanMessageLogin = driver.findElement(By.xpath(".//*[@id='welcome-panel']/div/h2")).getText();
		
		//assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("Welcome to"));
		
		if(actuanMessageLogin.contentEquals(expectedMessageLogin))							
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='wp-admin-bar-my-account']/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		WebElement subElement = driver.findElement(By.linkText("Log Out"));
		action.moveToElement(subElement);
		action.click();
		action.perform();
		
		String expectedMessageLogout = "You are now logged out.";
		String actuanMessageLogout = driver.findElement(By.xpath(".//*[@id='login']/p[1]")).getText();
		if(actuanMessageLogout.contentEquals(expectedMessageLogout))
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
