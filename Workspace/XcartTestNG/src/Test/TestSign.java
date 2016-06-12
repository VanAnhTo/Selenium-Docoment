package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Util;
import PageObject.ObjLogin;
import PageObject.ObjSign;

public class TestSign {
	private WebDriver  driver;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",Util.CHROME_DRIVER);
		driver = new ChromeDriver();		
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1, enabled = true)
	public void signSuccessfull() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("vananh123@gmail.com");
		driver.findElement(ObjSign.txtPass).sendKeys("123");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("123");
		driver.findElement(ObjSign.btnCreat).click();
		
		//String expectedMess = driver.findElement(ObjSign.actualMessSuccess).getText();
		String actualTile= driver.getTitle();
		if(ObjSign.expectedTitle.contentEquals(actualTile))
		{
			System.out.println("sign success");
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.findElement(ObjLogin.linkLogOut).click();
	}
	@Test(priority = 2, enabled = true)
	public void signInvalidEmail() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("email");
		driver.findElement(ObjSign.txtPass).sendKeys("123");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("123");
		driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = driver.findElement(ObjSign.actualMessInvalidEmail).getText();
		if(ObjSign.expectedMessInvalidEmail.contentEquals(actualMess))
		{
			System.out.println("Validated invalid email");
		}
		else
		{
			System.out.println("Not Validated invalid email");
		}
	}
	@Test(priority = 3, enabled = true)
	public void signInvalidConfirmPass() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("email@gmail.com");
		driver.findElement(ObjSign.txtPass).sendKeys("123");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("321");
		driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = driver.findElement(ObjSign.actualMessInvalidConPass).getText();
		if(ObjSign.expectedMessInvalidConPass.contentEquals(actualMess))
		{
			System.out.println("Validated invalid confirm pass");
		}
		else
		{
			System.out.println("Not Validated invalid confirm pass");
		}
	}
	@Test(priority = 4, enabled = true)
	public void signWithoutEmail() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("");
		driver.findElement(ObjSign.txtPass).sendKeys("123");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("321");
		driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = driver.findElement(ObjSign.actualMessWithoutEmail).getText();
		if(ObjSign.expectedMessWithoutEmail.contentEquals(actualMess))
		{
			System.out.println("Validated without email");
		}
		else
		{
			System.out.println("Not Validated without email");
		}
	}
	@Test(priority = 5, enabled = true)
	public void signWithoutPass() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("cc@gmail.com");
		driver.findElement(ObjSign.txtPass).sendKeys("");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("321");
		driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = driver.findElement(ObjSign.actualMessWithoutPass).getText();
		if(ObjSign.expectedMessWithoutPass.contentEquals(actualMess))
		{
			System.out.println("Validated without pass");
		}
		else
		{
			System.out.println("Not Validated without pass");
		}
	}
	@Test(priority = 6, enabled = true)
	public void signWithoutConfPass() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("q@gmail.com");
		driver.findElement(ObjSign.txtPass).sendKeys("123");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("");
		driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = driver.findElement(ObjSign.actualMessWithoutConfPass).getText();
		if(ObjSign.expectedMessWithoutConfPass.contentEquals(actualMess))
		{
			System.out.println("Validated without confirm pass");
		}
		else
		{
			System.out.println("Validated without confirm pass");
		}
	}
	@Test(priority = 7, enabled = true)
	public void signExistEmail() throws InterruptedException, IOException 
	{
		driver.get(Util.URL+"?target=profile&mode=register");
		driver.findElement(ObjSign.txtEmail).sendKeys("q@gmail.com");
		driver.findElement(ObjSign.txtPass).sendKeys("123");
		driver.findElement(ObjSign.txtConfirmPass).sendKeys("123");
		driver.findElement(ObjSign.btnCreat).click();
		
		String actualMess = driver.findElement(ObjSign.actualMessExistEmail).getText();
		if(ObjSign.expectedMessExistEmail.contentEquals(actualMess))
		{
			System.out.println("Validated exist email");
		}
		else
		{
			System.out.println("Not Validated exist email");
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		driver.close();
		
	}
	
}
