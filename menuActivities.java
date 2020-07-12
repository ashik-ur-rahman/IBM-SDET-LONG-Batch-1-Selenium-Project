package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class menuActivities {
  WebDriver driver;

  @Test
  public void menuAct() {
	  driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("admin"); 
	  driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='grouptab_3']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='grouptab_3']")).isEnabled());
	  
	  
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
