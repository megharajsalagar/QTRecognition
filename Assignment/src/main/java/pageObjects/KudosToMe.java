package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KudosToMe {

	
	static By kudosToMeButton=By.xpath("//a[@onclick='shoutOutToMe()']");
	static By listOfKudos=By.id("shoutout_to_me");
	
	public static WebElement getKudosToMeButton(WebDriver driver) {
		return driver.findElement(kudosToMeButton);
	}
	
	public static List<WebElement> getListOfKudos(WebDriver driver) {
		return driver.findElements(listOfKudos);
	}
}
