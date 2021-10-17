package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityPage {
	
	static By eName=By.xpath("//h5[@class='header-font-size']");
	static By image=By.xpath("//img[@alt='Sample Image']");
	static By sendKudos=By.xpath("//a[@href='#myModal']");
	static By email=By.className("form-control");
	static By trophyList=By.xpath("//div[@id='trophy_list']/div");
	static By kudosSearch=By.xpath("//*[contains(text(),'Kudos Search')]");
	
	static By comment=By.id("comment");
	
	static By sendKudosButton=By.xpath("//button[@class='btn btn-primary']");
	
	public static WebElement getEmployeeName(WebDriver driver) {
		return driver.findElement(eName);
	}
	
	public static WebElement getImage(WebDriver driver) {
		return driver.findElement(image);
	}
	
	public static WebElement getSendKudosButton(WebDriver driver) {
		return driver.findElement(sendKudos);
	}
	
	public static WebElement getEmail(WebDriver driver) {
		return driver.findElement(email);
	}
	
	public static List<WebElement> getTrophyList(WebDriver driver) {
		return driver.findElements(trophyList);
	}
	
	public static WebElement getComment(WebDriver driver) {
		return driver.findElement(comment);
	}
	
	public static WebElement getKudosButton(WebDriver driver) {
		return driver.findElement(sendKudosButton);
	}
	
	public static WebElement getKudosSearch(WebDriver driver) {
		return driver.findElement(kudosSearch);
	}
	
}
