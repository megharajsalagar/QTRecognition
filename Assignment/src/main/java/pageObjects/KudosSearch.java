package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KudosSearch {
	
	static By kudosSearch=By.xpath("//a[@onclick='searchKudosByUser()']");
	static By kudosSearchInput=By.id("s_e_add");
	static By kudosSearchButton=By.xpath("//button[@onclick='kudosSearch()']");
	
	public static WebElement getKudosSearch(WebDriver driver) {
		return driver.findElement(kudosSearch);
	}
	public static WebElement getKudosSearchInput(WebDriver driver)
	{
		return driver.findElement(kudosSearchInput);
	}
	public static WebElement getKudosSearchButton(WebDriver driver) {
		return driver.findElement(kudosSearchButton);
	}
	
}
