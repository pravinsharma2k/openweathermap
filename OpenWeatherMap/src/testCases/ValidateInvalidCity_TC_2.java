package testCases;

import org.testng.annotations.Test;
import helperImpl.OpenWeatherImpl;
import util.Initialization;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ValidateInvalidCity_TC_2 {
  
static WebDriver driver;

@BeforeClass
public static WebDriver browserStart(){
		return driver = Initialization.InitialiseAndStart();		
}
 
@Test
 public void checkInvalidCityWeather()
 {
	
	
	OpenWeatherImpl objWeather = new OpenWeatherImpl(driver);
	String actualTitle =  driver.getTitle();
	// common method which will check title of the page- valid page opened or not
	objWeather.ValidateTitleofPage("weather and forecast - OpenWeatherMap");
	
	// Check for error message - Not Found
	String actualText = objWeather.checkInvalidCityWeather("NotCity"); // replace with parameterisation
	String expectedError = "Not found";
	assertTrue(actualText.contains(expectedError), "Not Found errormessage did not appeared when user click on submitt button ");
	//objWeather.ValidateTitleofPage("weather and forecast - OpenWeatherMap");
	
	
 }

  @AfterTest
  public void afterTest() {
	//  driver.close();
  }

}
