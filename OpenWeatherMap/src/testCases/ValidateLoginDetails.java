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

public class ValidateLoginDetails {
  
static WebDriver driver;

String expected = "Success!";

@BeforeClass
public static WebDriver browserStart(){
		return driver = Initialization.InitialiseAndStart();		
}
 
@Test
 public void login()
 {
	OpenWeatherImpl objWeather = new OpenWeatherImpl(driver);
	objWeather.login("pravinsharma2k@gmail.com","mypassword");
	objWeather.ValidateTitleofPage("Members");
 
 }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}