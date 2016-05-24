package TestSuite1;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class addUser {
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
	public void testAddUser_basic() throws Exception {	
		
		driver.get(baseUrl);		
		driver.findElement(By.xpath(".//*[@id='meta-2']/ul/li[2]/a")).click();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("123456");
		driver.findElement(By.id("wp-submit")).click();	
		
		String expectedMessageLogin = "Welcome to WordPress!";
		String actuanMessageLogin = driver.findElement(By.xpath(".//*[@id='welcome-panel']/div/h2")).getText();
		
		
		
		if(actuanMessageLogin.contentEquals(expectedMessageLogin))							
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*to WordPress![\\s\\S]*$"));
		
		//driver.findElement(By.xpath(".//*[@id='menu-users']/ul/li[3]/a")).click();
		driver.findElement(By.xpath(".//*[@id='menu-users']/a/div[3]")).click();
		driver.findElement(By.xpath(".//*[@id='menu-users']/ul/li[3]/a")).click();
		
		
		driver.findElement(By.id("user_login")).sendKeys("vananhhh");
		driver.findElement(By.id("email")).sendKeys("emailll1@gmail.com");
		driver.findElement(By.id("first_name")).sendKeys("To");
		driver.findElement(By.id("last_name")).sendKeys("Anh");
		driver.findElement(By.id("url")).sendKeys("web.com.vn");
		
		driver.findElement(By.id("createusersub")).click();
		
		String expectedMessageAddUser = "New user created. Edit user";
		String actuanMessageAddUser = driver.findElement(By.xpath(".//*[@id='message']/p")).getText();
		
		
		if(actuanMessageAddUser.contentEquals(expectedMessageAddUser))							
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}		
		
		assertEquals(expectedMessageAddUser,actuanMessageAddUser);		
		
	}
	@After
	public void tearDown() throws Exception {
		
		//driver.quit();
	}
}
