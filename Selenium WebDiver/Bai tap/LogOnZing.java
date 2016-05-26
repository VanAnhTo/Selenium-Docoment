package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogOnZing {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl ="https://id.zing.vn/v2/register";
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testLogOnZing() throws Exception
	{
		driver.get(baseUrl);
		driver.findElement(By.id("regacc_fullname")).sendKeys("Van Anh To");
		driver.findElement(By.id("regacc_account")).sendKeys("vananhto112233");
		driver.findElement(By.id("regacc_pwd")).sendKeys("123321");
		driver.findElement(By.id("regacc_re_pwd")).sendKeys("123321");
		driver.findElement(By.xpath(".//*[@id='dob']/option[3]")).click();
		driver.findElement(By.xpath(".//*[@id='mob']/option[4]")).click();
		driver.findElement(By.xpath(".//*[@id='yob']/option[16]")).click();
		driver.findElement(By.className("reg_sex")).isSelected();
		//driver.findElement(By.className("zid_regbtn")).click();
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
}