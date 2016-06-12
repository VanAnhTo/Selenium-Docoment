package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.Util;
import PageObject.*;

public class TestLogin {
	private WebDriver  driver;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",Util.CHROME_DRIVER);
		driver = new ChromeDriver();		
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1, enabled = true)
	public void loginSuccessfull() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.txtEmail).clear();
		driver.findElement(ObjLogin.txtEmail).sendKeys("q@gmail.com");
		driver.findElement(ObjLogin.txtPass).sendKeys("123");
		driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualTitle = driver.getTitle();
		if(ObjLogin.expectedTitle.contentEquals(actualTitle))
		{
			System.out.println("login success");
		}
		else
		{
			System.out.println("log in fail");
		}
		Thread.sleep(3000);
		
		driver.findElement(ObjLogin.linkLogOut).click();
		
	}
	@Test(priority = 2, enabled = true)
	public void loginInvalidEmail() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.txtEmail).clear();
		driver.findElement(ObjLogin.txtEmail).sendKeys("email");
		driver.findElement(ObjLogin.txtPass).sendKeys("123");
		driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = driver.findElement(ObjLogin.actualMessInvalidEmail).getText();
		if(ObjLogin.expectedMessInvalidEmail.contentEquals(actualMess))
		{
			System.out.println("Validated invalid email");
		}
		else
		{
			System.out.println("Not Validated invalid email");
		}
		
		
	}
	@Test(priority = 3, enabled = true)
	public void loginIncorectEmail() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.txtEmail).clear();
		driver.findElement(ObjLogin.txtEmail).sendKeys("w@gmai.com");
		driver.findElement(ObjLogin.txtPass).sendKeys("123");
		driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = driver.findElement(ObjLogin.actualMessIncorrEmail).getText();
		if(ObjLogin.expectedMessIncorrEmail.contentEquals(actualMess))
		{
			System.out.println("Validated incorrect email");
		}
		else
		{
			System.out.println("Not Validated incorrect email");
		}		
	}
	@Test(priority = 4, enabled = true)
	public void loginWithoutPass() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.txtEmail).clear();
		driver.findElement(ObjLogin.txtEmail).sendKeys("22@gmai.com");
		driver.findElement(ObjLogin.txtPass).sendKeys("");
		driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = driver.findElement(ObjLogin.actualMessWithoutPass).getText();
		if(ObjLogin.expectedMessWithoutPass.contentEquals(actualMess))
		{
			System.out.println("Validated without pass");
		}
		else
		{
			System.out.println("Not Validated without pass");
		}		
	}
	@Test(priority = 5, enabled = true)
	public void loginInvalidPass() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.txtEmail).clear();
		driver.findElement(ObjLogin.txtEmail).sendKeys("q@gmai.com");
		driver.findElement(ObjLogin.txtPass).sendKeys("222");
		driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = driver.findElement(ObjLogin.actualMessInvalidPass).getText();
		if(ObjLogin.expectedMessInvalidPass.contentEquals(actualMess))
		{
			System.out.println("Validated invalid pass");
		}
		else
		{
			System.out.println("Not Validated invalid pass");
		}		
	}
	@Test(priority = 6, enabled = true)
	public void loginWithoutEmail() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.txtEmail).clear();
		driver.findElement(ObjLogin.txtEmail).sendKeys("");
		driver.findElement(ObjLogin.txtPass).sendKeys("222");
		driver.findElement(ObjLogin.btnSignIn).click();
		
		String actualMess = driver.findElement(ObjLogin.actualMessWithoutEmail).getText();
		if(ObjLogin.expectedMessWithoutEmail.contentEquals(actualMess))
		{
			System.out.println("Validated without email");
		}
		else
		{
			System.out.println("Not Validated without email");
		}	
		Thread.sleep(3000);
	}
	@Test(priority = 7, enabled = true)
	public void loginForgotPass() throws InterruptedException, IOException 
	{
		driver.get(Util.URL);
		driver.findElement(ObjLogin.linkLogin).click();
		driver.findElement(ObjLogin.linkForgotPass).click();
		
		
		String actualMess = driver.findElement(ObjLogin.actualMessWithoutEmail).getText();
		if(ObjLogin.expectedMessWithoutEmail.contentEquals(actualMess))
		{
			System.out.println("Show popup forgot pass success");
		}
		else
		{
			System.out.println("Show popup forgot pass fail");
		}		
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		driver.close();
		
	}
}
