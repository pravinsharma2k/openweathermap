package util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialization {
	
	 static WebDriver driver;
	
	 	static public WebDriver InitialiseAndStart(String url)
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\Java\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.wait(timeout);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}

	static public WebDriver InitialiseAndStart()
	{
		
		driver = InitialiseAndStart("https://openweathermap.org/");
		
		/*			List <WebElement> frames = driver.findElements(By.cssSelector("frame"));
	for(WebElement frame:frames){
			String frameName = frame.getAttribute("name");
			System.out.println("\n---------- " + frameName+ "---------- \n");
			driver.switchTo().frame(frameName);
			List <WebElement> links = driver.findElements(By.cssSelector("a"));
			for(WebElement link:links){
				System.out.println(link.getText());
			}
			driver.switchTo().defaultContent();
		}*/

		return driver;
	}

}
