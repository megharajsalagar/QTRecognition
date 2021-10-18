package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityPage {
	
	static By eName=By.xpath("//h5[@class='header-font-size']");
	static By image=By.xpath("//img[@alt='Sample Image']");
	
	
	public static WebElement getEmployeeName(WebDriver driver) {
		return driver.findElement(eName);
	}
	
	public static WebElement getImage(WebDriver driver) {
		return driver.findElement(image);
	}

	
}
