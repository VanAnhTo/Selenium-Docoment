package TestSuite1;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class verifyContact {
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
	public void TestVerifyContact() throws Exception {
		driver.get(baseUrl + "/contact/");		
		driver.findElement(By.id("wdform_1_element_first5")).sendKeys("Anh");
		driver.findElement(By.id("wdform_1_element_last5")).sendKeys("To");
		driver.findElement(By.id("wdform_2_element5")).sendKeys("email@gmail.com");
		driver.findElement(By.id("wdform_3_element_first5")).sendKeys("84");
		driver.findElement(By.id("wdform_3_element_last5")).sendKeys("12323123112");
		driver.findElement(By.id("wdform_4_element5")).sendKeys("My message");
		driver.findElement(By.className("button-submit")).click();	
		
		String expectedMessage ="Your form was successfully submitted.";
		String actualMessage = driver.findElement(By.xpath(".//*[@id='post-8']/div/div/div/p")).getText();
		if(actualMessage.contentEquals(expectedMessage))
		{
			System.out.print("Test passed");
		}
		else 
		{
			System.out.print("Test Failed");
		}
		
		
	}
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
}
