package testCases;

import org.testng.annotations.Test;
import helperImpl.OpenWeatherImpl;
import util.Initialization;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ValidateWeatherInfo_TC_01 {
  
static WebDriver driver;

String expected = "Success!";

@BeforeClass
public static WebDriver browserStart(){
		return driver = Initialization.InitialiseAndStart();		
}
 
@Test
 public void checkCityWeather()
 {
	OpenWeatherImpl objWeather = new OpenWeatherImpl(driver);
	// common method which will check title of the page- valid page opened or not
	objWeather.ValidateTitleofPage("weather and forecast - OpenWeatherMap");
	objWeather.checkCityWeather("Mumbai"); // replace with parameterisation
	

	// common method which will check title of the page- valid page opened or not
	// check for Find Page
	objWeather.ValidateTitleofPage("Find - OpenWeatherMap");
	
	// check for correct city is listed or not
	String actualString = objWeather.validateCity("Mumbai","IN");
	assertTrue(actualString.contains("Mumbai"), " Find weather in city is not successfull");
	
}

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}