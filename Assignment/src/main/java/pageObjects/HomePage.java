package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	static By uname =By.name("username");
	static By pass=By.name("pass");
	static By button=By.xpath("//*[text()='Login']");
	static By bgcolor=By.xpath("//div[@class='myHeading']");
			

	public  static WebElement getUsername(WebDriver driver) {
		return driver.findElement(uname);
		
	}
	
	public static WebElement getPassword(WebDriver driver) {
		return driver.findElement(pass);
	}
	
	public static WebElement getButton(WebDriver driver) {
		return driver.findElement(button);
	}
	
	public static WebElement getBgColor(WebDriver driver) {
		return driver.findElement(bgcolor);
	}

}
