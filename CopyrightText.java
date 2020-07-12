package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CopyrightText {

	WebDriver driver;
	
  @Test
  public void copyright() {
	  WebElement Text1 = driver.findElement(By.xpath("//*[@id='admin_options']")); 
	  WebElement Text2 = driver.findElement(By.xpath("//*[@id='powered_by']")); 
	  
	  System.out.println("The copyright texts are : " + Text1.getText() + ", " + Text2.getText());
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();	  
  }

}
