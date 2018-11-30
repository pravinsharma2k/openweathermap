package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {
static public WebElement getElement(WebDriver driver, String locator, String locatorValue)
{
	WebElement element = null;
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	if(locator.toUpperCase().equals("CSSSELECTOR"))
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
		else if(locator.toUpperCase().equals("XPATH"))
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		else if(locator.toUpperCase().equals("ID"))
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			
	return element;
}
	
}


