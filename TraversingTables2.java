package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TraversingTables2 {
	  WebDriver driver;

	  @Test
	  public void oddRow() throws InterruptedException {
		  driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("admin"); 
		  driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys("pa$$w0rd");
		  driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
		  driver.findElement(By.xpath("//a[text()='Sales']")).click();
		    Thread.sleep(5000);
		  
	        WebElement leadsMenu = driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']"));
	        leadsMenu.click();
	        Thread.sleep(5000);

	        // Printing the Name and User in the first 10 rows 
		    for(int i=1;i<=10;i++) {
	       		String Name = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr["+i+"]/td[3]/b/a")).getText();
		    	String User = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[8]/a")).getText();
		    	System.out.println("Row "+i+" : Name - "+Name+", User - "+User);
		    	
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
