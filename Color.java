package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;


public class Color {
  WebDriver driver;

  @Test
  public void color() {
	  driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("admin"); 
	  driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
	  // Storing the value in RGB format
	  String color = driver.findElement(By.xpath("//*[@id='toolbar']")).getCssValue("color");
	  System.out.print(color);

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
