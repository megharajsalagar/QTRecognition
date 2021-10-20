package qualitest;

import static org.testng.Assert.assertFalse;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ActivityPage;
import pageObjects.HomePage;
import pageObjects.KudosFromMe;
import pageObjects.KudosSearch;
import pageObjects.KudosToMe;
import pageObjects.SendKudos;

public class AppTest extends App
{

	private static final Logger logger = LogManager.getLogger(AppTest.class);
	@BeforeTest
	public void a() throws IOException {
		driver = setUp();
	}

	@Test 
	public void login1() throws IOException ,InterruptedException {
		//Login with wrong credentials 
			driver.get(properties.getProperty("url"));
			HomePage.getUsername(driver).sendKeys("megharaj");
			HomePage.getPassword(driver).sendKeys("Password");
			HomePage.getButton(driver).click();
			Thread.sleep(2000);
			//accept the alert
			driver.switchTo().alert().accept();
	}
	
	@Test
	public void login2() throws InterruptedException {
		//Login with empty credentials
		driver.get(properties.getProperty("url"));
		HomePage.getUsername(driver).sendKeys("");
		HomePage.getPassword(driver).sendKeys("");
		HomePage.getButton(driver).click();
		//To verify the successful login 
		//Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("exp_login_url"));

	}
	@Test
	public void verifyTitle() {
		//Application title verification
		driver.get(properties.getProperty("url"));
		Assert.assertEquals("QTRecognition",driver.getTitle());
	}
	
	@Test
	public void homePageColors() {
		//Verify given colors with home page
		try {
		driver.get(properties.getProperty("url"));
		String rgbaformHeading=HomePage.getBgColor(driver).getCssValue("background-color");
		String rgbaformButton=HomePage.getButton(driver).getCssValue("background-color");
		String rgbaformBody=HomePage.getButton(driver).getCssValue("color");
		String hexformHeading=org.openqa.selenium.support.Color.fromString(rgbaformHeading).asHex();
		String hexformButton=org.openqa.selenium.support.Color.fromString(rgbaformButton).asHex();
		String hexformBody=org.openqa.selenium.support.Color.fromString(rgbaformBody).asHex();
		
		//System.out.println(hexformBody);
		
			Assert.assertEquals("#fdcc16",hexformHeading);
			Assert.assertEquals("#2a2559",hexformButton);
			Assert.assertEquals("#ffffff",hexformBody);
			logger.info("Background color is Gold");
			logger.info("Button color is Navy");
			logger.info("Body color is White");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

	
	@Test
	public void login3() throws InterruptedException {
		//Login with valid credentials
		
		driver.get(properties.getProperty("url"));
		HomePage.getUsername(driver).sendKeys("megharaj.salagar@qualitestgroup.com");
		HomePage.getPassword(driver).sendKeys("P@ssW0rd");
		HomePage.getButton(driver).click();
		Thread.sleep(3000);
		ActivityPage.getEmployeeName(driver).getText();
		
		//verify employee name and image
		try {
			Assert.assertEquals("Megharaj Salagar",ActivityPage.getEmployeeName(driver).getText());
			Assert.assertTrue(ActivityPage.getImage(driver).isDisplayed());
			logger.info("Employee name is present left side of the Activity Page");
			logger.info("Image is present");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	 
	
	@Test
	public void searchKudos() throws InterruptedException {
		//Search kudos by name or email
		 KudosSearch.getKudosSearch(driver).click();
		 Thread.sleep(3000);
		 KudosSearch.getKudosSearchInput(driver).sendKeys("Kushalappa P A  (kushalappa.pa@qualitestgroup.com)");
		 Thread.sleep(2000);
		 KudosSearch.getKudosSearchButton(driver).click();
	}
	
	 @Test
	  public void seeKudosFromMe() throws InterruptedException {
		  KudosFromMe.getKudosFromMeButton(driver).click();
		  Thread.sleep(2000);
		  assertFalse(KudosFromMe.getListOfKudos(driver).isEmpty());
		  logger.info("List Of Kudos are Present in Kudos From Me section");
	  }
	 
	 @Test
	  public void seeKudosToMe() throws InterruptedException {
		  KudosToMe.getKudosToMeButton(driver).click();
		  Thread.sleep(2000);
		  assertFalse(KudosToMe.getListOfKudos(driver).isEmpty());
		  logger.info("List Of Kudos are Present in Kudos To Me section");
	  }
	
	
	  @Test 
	  public void sendKudos() throws InterruptedException { 
	   //Perform the sendKudos operation
	  
		
		  try {
			  SendKudos.getSendKudosButton(driver).click(); 
			  Thread.sleep(3000);
			  SendKudos.getEmail(driver).
			  sendKeys("Yashawanthkumar Hodlur  (yashawanthkumar.hodlur@qualitestgroup.com)");
			  List<WebElement> list=SendKudos.getTrophyList(driver);
			  list.get(0).click();
			  SendKudos.getComment(driver).sendKeys("Excelent work is going on keep it up!");
			  Thread.sleep(2000); 
			  SendKudos.getKudosButton(driver).click();
			  Thread.sleep(4000);
			  logger.info(SendKudos.getMsg(driver).getText());
		  }
		  catch(Exception e)
		  {
			  logger.error("Error occured while sending kudos!");
		  }
		 
		 
	  
	  }
	
		@AfterTest 
		 public void driverExit() 
		 { 
			driver.quit();
		} 
	 

}
