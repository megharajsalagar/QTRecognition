package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKudos {
	static By sendKudos=By.xpath("//a[@href='#myModal']");
	static By email=By.className("form-control");
	static By trophyList=By.xpath("//div[@id='trophy_list']/div");
	static By comment=By.id("comment");
	static By sendKudosButton=By.xpath("//button[@class='btn btn-primary']");
	static By msg=By.xpath("//*[@id=\"display_message\"]/span");
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
	public static WebElement getMsg(WebDriver driver) {
		return driver.findElement(msg);
	}
	
}
