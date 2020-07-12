package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class addnlInfo {
	  WebDriver driver;

  @Test
  public void additionalInfo() throws InterruptedException {
		  driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("admin"); 
		  driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys("pa$$w0rd");
		  driver.findElement(By.xpath("//*[@id='bigbutton']")).click();
		  driver.findElement(By.xpath("//a[text()='Sales']")).click();
	        Thread.sleep(5000);
		  
	        WebElement leadsMenu = driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']"));
	        System.out.println("leadsmenu exists : "	+ leadsMenu.getText());
	        Assert.assertTrue(leadsMenu.isDisplayed(), "Leads is displayed");
	        leadsMenu.click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Thread.sleep(5000);
	        
	      //Create Lead
	        String myFName = "Ashik ur";
	        String myLName = "Rahman";
			driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
			Thread.sleep(2000);
			Select salution=new Select(driver.findElement(By.xpath("//*[@id='salutation']")));
			salution.selectByVisibleText("Mr.");
			driver.findElement(By.id("first_name")).sendKeys(myFName);
			driver.findElement(By.id("last_name")).sendKeys(myLName);
			driver.findElement(By.id("phone_work")).sendKeys("9876543210");
			driver.findElement(By.id("phone_mobile")).sendKeys("9876543210");
			driver.findElement(By.id("SAVE")).click();
			Thread.sleep(10000);
	        
			//Navigate to View Leads Page
			driver.findElement(By.xpath("//div[text()='View Leads']")).click();
			Thread.sleep(5000);
			
	        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr"));
	        int count = rows.size();
			
        	for(int i=1;i<=count;i++) {
        		String Name = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr["+i+"]/td[3]/b/a")).getText();
        		if (Name.contains(myFName+" "+myLName)==true) {
            		System.out.println("Name : "+Name);
            		driver.findElement(By.xpath("(//span[@title='Additional Details'])["+i+"]")).click();
        			//Get the Last Row Phone Number
        			String sphoneNumber = driver.findElement(By.xpath("//span[@class='phone']")).getText();
        			
        			//Print the Phone Number
        			System.out.println("Phone number : "+sphoneNumber);

            		break;
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
