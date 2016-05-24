package TestSuite1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class newClass {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();		
		//driver.manage().window().maximize();
		baseUrl = "https://translate.google.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testGoogleTrans() throws Exception {
		driver.get(baseUrl + "/#en/vi/");		
		driver.findElement(By.id("source")).clear();
		driver.findElement(By.id("source")).sendKeys("test");
		driver.findElement(By.id("gt-submit")).click();		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
