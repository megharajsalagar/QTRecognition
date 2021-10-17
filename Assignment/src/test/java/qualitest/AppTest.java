package qualitest;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ActivityPage;
import pageObjects.HomePage;
public class AppTest extends App
{

	@BeforeTest
	public void a() throws IOException {
		driver = setUp();
	}

	@Test 
	public void login1() throws IOException ,InterruptedException {
			driver.get(properties.getProperty("url"));
			HomePage.getUsername(driver).sendKeys("megharaj");
			HomePage.getPassword(driver).sendKeys("Password");
			HomePage.getButton(driver).click();
			Thread.sleep(2000);
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
		driver.get(properties.getProperty("url"));
		Assert.assertEquals("QTRecognition",driver.getTitle());
	}
	
	@Test
	public void homePageColors() {
		driver.get(properties.getProperty("url"));
		String rgbaformHeading=HomePage.getBgColor(driver).getCssValue("background-color");
		String rgbaformButton=HomePage.getButton(driver).getCssValue("background-color");
		String rgbaformBody=HomePage.getButton(driver).getCssValue("color");
		String hexformHeading=org.openqa.selenium.support.Color.fromString(rgbaformHeading).asHex();
		String hexformButton=org.openqa.selenium.support.Color.fromString(rgbaformButton).asHex();
		String hexformBody=org.openqa.selenium.support.Color.fromString(rgbaformBody).asHex();
		
		System.out.println(hexformBody);
		try {
			Assert.assertEquals("#fdcc16",hexformHeading);
			Assert.assertEquals("#2a2559",hexformButton);
			Assert.assertEquals("#ffffff",hexformBody);
			System.out.println("Background color is Gold");
			System.out.println("Button color is Navy");
			System.out.println("Body color is White");
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
		try {
			Assert.assertEquals("Megharaj Salagar",ActivityPage.getEmployeeName(driver).getText());
			//Assert.assertTrue());
			Assert.assertTrue(ActivityPage.getImage(driver).isDisplayed());
			System.out.println("Employee name is present left side of the Activity Page");
			System.out.println("Image is present");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//To verify the successful login 
		//Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("exp_login_url"));
		

	}
	
	
	  @Test 
	  public void sendKudos() throws InterruptedException {
	  
	  ActivityPage.getSendKudosButton(driver).click(); Thread.sleep(3000);
	  ActivityPage.getEmail(driver).
	  sendKeys("Kushalappa P A  (kushalappa.pa@qualitestgroup.com)"); List
	  <WebElement> list=ActivityPage.getTrophyList(driver); list.get(0).click();
	  //System.out.println(ActivityPage.getTrophyList(driver).getText());
	  ActivityPage.getComment(driver).
	  sendKeys("Excelent work is going on keep it up!"); Thread.sleep(2000);
	  ActivityPage.getKudosButton(driver).click(); Thread.sleep(2000); 
	  }
	 
		/*
		 * @Test public void kudosSearch() throws InterruptedException {
		 * Thread.sleep(4000); ActivityPage.getKudosSearch(driver).click();
		 * Thread.sleep(4000);
		 * 
		 * }
		 */
	

	
	
	  @AfterTest public void driverExit() { driver.quit(); }
	 

}
