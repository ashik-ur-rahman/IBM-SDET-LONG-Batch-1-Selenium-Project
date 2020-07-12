package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TraversingTables1 {
  WebDriver driver;

  @Test
  public void oddRow() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("admin"); 
	  driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
	  driver.findElement(By.xpath("//a[text()='Sales']")).click();
	    Thread.sleep(5000);
	  
	    WebElement leadsMenu = driver.findElement(By.xpath("//a[@id='moduleTab_9_Accounts']"));
	    leadsMenu.click();
	    Thread.sleep(5000);
		
	    List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr"));
	    int count = rows.size();
	    System.out.println("First five odd number rows are : ");
		for(int i=1;i<=count;i=i+2) {
			if(i<=9) {
			String Name = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr["+i+"]/td[3]/b/a")).getText();
			System.out.println(Name);
			}
		}

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
