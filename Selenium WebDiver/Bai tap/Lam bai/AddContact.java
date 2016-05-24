package TestSuite1;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddContact {
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
		driver.get(baseUrl + "/contact/");		
		driver.findElement(By.id("wdform_1_element_first5")).sendKeys("Anh");
		driver.findElement(By.id("wdform_1_element_last5")).sendKeys("To");
		driver.findElement(By.id("wdform_2_element5")).sendKeys("email@gmail.com");
		driver.findElement(By.id("wdform_3_element_first5")).sendKeys("84");
		driver.findElement(By.id("wdform_3_element_last5")).sendKeys("12323123112");
		driver.findElement(By.id("wdform_4_element5")).sendKeys("My message");
		driver.findElement(By.className("button-submit")).click();	
		//driver.findElement(By.xpath(".//*[@id='5form_view1']/div[1]/div/div[5]/div/div[2]/button[1]")).click();	
		//driver.findElement(By.xpath(".//*[@id='post-8']/div/div/div/p/strong")).getCssValue("Your form was successfully submitted.");
		//driver.findElement(By.className("warning")).getCssValue("Your form was successfully submitted.");
	}
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
}
