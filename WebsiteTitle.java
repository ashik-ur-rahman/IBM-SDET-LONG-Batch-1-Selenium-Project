package Activities;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class WebsiteTitle {
  
	WebDriver driver;
	@Test
  public void getTitle() {
	  System.out.println("Website title is : "+ driver.getTitle());
  }
  
	@BeforeTest
  public void beforeTest() {
      driver = new FirefoxDriver();

      //Open browser
      driver.get("https://alchemy.hguy.co/crm");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
