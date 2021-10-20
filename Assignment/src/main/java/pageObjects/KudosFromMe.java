package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KudosFromMe {
	static By kudosFromMeButton=By.xpath("//a[@onclick='shoutOutFromMe()']");
	static By listOfKudos=By.id("shoutout_to_me");
	
	public static WebElement getKudosFromMeButton(WebDriver driver) {
		return driver.findElement(kudosFromMeButton);
	}
	
	public static List<WebElement> getListOfKudos(WebDriver driver) {
		return driver.findElements(listOfKudos);
	}

}
