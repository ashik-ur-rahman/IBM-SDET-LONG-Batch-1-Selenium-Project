package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class urlHeaderImg {
	WebDriver driver;
	
  @Test
  public void f() {
	  
	//Path of header image
	  WebElement imageHeader2= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[1]/img")); 
	  System.out.println("URL of header image : " + imageHeader2.getAttribute("src"));	  

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
