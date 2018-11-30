
package helperImpl;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import helper.OpenWeatherHomePage;
import util.Elements;

public class OpenWeatherImpl implements OpenWeatherHomePage{

 private WebDriver driver;

 public OpenWeatherImpl(WebDriver driver){
		this.driver = driver;
 }
	
	public void login(String uname, String pwd) {
		clickonSignIn();
		enterUserName(uname);
		enterPwd(pwd);
		clickOnSubmit();
	}

	@Override
	public String checkCityWeather(String cityName) {
		enterCityName(cityName);
		clickOnSearchLink();
		return null;
	}

	public String checkInvalidCityWeather(String cityName) {
		enterCityName(cityName);
		clickOnSearchLink();
	
		 String actText = Elements.getElement(driver, "XPATH", "//div[@role='alert']").getText();
		return actText;
	}
	
	public String ValidateTitleofPage(String TitleName)
	{
	String actualTitle =  driver.getTitle();
	assertTrue(actualTitle.contains(TitleName), "Title of the page did not contain the "+ TitleName );
	return actualTitle;
	}
	
	public String validateCity(String cityName, String stateCode)
	{
		String city = "'"+ cityName + ", " + stateCode.toUpperCase() + "'";
		String Actualcity = Elements.getElement(driver, "XPATH", "//a[contains(text(),"+city+")"+"]").getText();
		return Actualcity;
		
	}	
	
/* <--------------------------------- unit Layered functions -----------------------------------------> */
	

	
	private void enterCityName(String cityName){
		
		Elements.getElement(driver, "XPATH", "//input[@id='q'][@placeholder='Your city name']").sendKeys(cityName);
	}

	private void clickOnSearchLink()  {
		WebElement element = Elements.getElement(driver, "XPATH", "//*[@id='searchform']/button");
				element.click();

	}

	private void enterUserName(String uname){
		Elements.getElement(driver, "XPATH", "//input[@placeholder='Enter email'][@class='string email optional form-control']").sendKeys(uname);
}

//mypassword
private void enterPwd(String pwd){
	Elements.getElement(driver, "XPATH", "//input[@id='user_password']").sendKeys(pwd);
}

private void clickOnSubmit() {
	Elements.getElement(driver, "XPATH", "//input[@name='commit'][@value='Submit']").click();
}

private void clickonSignIn()
{
	Elements.getElement(driver, "XPATH", "//a[@href='//home.openweathermap.org/users/sign_in'][@class='pull-right']").click();

}


/* <--------------------------------- end of unit Layered functions -----------------------------------------> */
	
/* <--------------------------------- not impletemented methods ------------------------------------------> */

	//@Override
	public void signup(String uname, String pwd, String city, int pincode) {
		// TODO Auto-generated method stub
	}

	@Override
	public String checkWeather(String cityName, String State) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}