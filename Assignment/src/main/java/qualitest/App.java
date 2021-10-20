package qualitest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	
	public WebDriver driver;
	public Properties properties;

	
	public WebDriver setUp() throws IOException {
		
	System.setProperty("webdriver.chrome.driver", "D:\\Qualitest\\driver\\chromedriver.exe");
	properties = new Properties();
	FileInputStream fis = new FileInputStream("D:\\Qualitest\\eclipse-workspace\\Assignment\\config.properties");
	properties.load(fis);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
	}
	
}
