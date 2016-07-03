package pageFactoryImpl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HomePage {
	WebDriver driver;

    @FindBy(css = "#tabContent .group:nth-child(1)")
    private WebElement menuCreateNL;
    
    @FindBy(css = ".container.z-div .z-div")
    private List<WebElement> allLabel;
    
    private WebElement labelCreate2dd;
    
    public void clickMenuCreateNL() {
        menuCreateNL.click();
    }
    
    public void clickLabelCreat2dd() {
    	labelCreate2dd = allLabel.get(1);
        labelCreate2dd.click();
    }
    
    public void goToCreate2dddPage() throws InterruptedException
    {
    	
    	clickMenuCreateNL();
    	Thread.sleep(3000);
    	clickLabelCreat2dd();
    }

    private void waitForHomePageToAppear() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.cssSelector("#tabContent .group:nth-child(1)")));
    }
    
    private ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement toReturn = driver.findElement(locator);
                if (toReturn.isDisplayed()) {
                    return toReturn;
                }
                return null;
            }
        };
    }

    
    
}
