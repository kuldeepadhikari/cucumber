package temprature_convertor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
//import org.openqa.selenium.firefox.MarionetteDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConversionStepDefs {
	public static WebDriver driver;
	

@Given("^User is on Home Page$")
public void user_is_on_Home_Page() throws Throwable {
	System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
	//Now you can Initialize marionette driver to launch firefox
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	WebDriver driver = new MarionetteDriver(capabilities); 

	// driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://www.store.demoqa.com");
    // Write code here that turns the phrase above into concrete actions
  //  throw new PendingException();
}
@When("^User enters Credentials to LogIn1$")
public void user_enters_testuser_and_Test(DataTable usercredentials) throws Throwable {
	//Write the code to handle Data Table
	//List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
	for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {
		driver.findElement(By.id("log")).clear();
	    driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("log")).sendKeys(data.get("Username")); 
	    driver.findElement(By.id("pwd")).sendKeys(data.get("Password"));
	    driver.findElement(By.id("login")).click();
		}
       }

@When("^User Navigate to LogIn Page$")
public void user_Navigate_to_LogIn_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath(".//*[@id='account']/a")).click();
  //  throw new PendingException();
}
@When("^User enters  \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_UserName_and_Password(String username, String password)  throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("log")).sendKeys(username); 	 
    driver.findElement(By.id("pwd")).sendKeys(password);
    driver.findElement(By.id("login")).click();
 //   throw new PendingException();
}

@Then("^Message displayed Login Successfully$")
public void message_displayed_Login_Successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Login Successfully");
//    throw new PendingException();
}

@When("^User LogOut from the Application$")
public void user_LogOut_from_the_Application() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
//	driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	//driver.close();
    try
{
driver.quit();
}

catch(Exception e)
{
e.printStackTrace();
System.out.println("not close");
        }
//    throw new PendingException();
}

@Then("^Message displayed LogOut Successfully$")
public void message_displayed_LogOut_Successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 System.out.println("LogOut Successfully");
//    throw new PendingException();
}

}
