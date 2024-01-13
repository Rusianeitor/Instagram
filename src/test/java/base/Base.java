package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(downloadTemplate());
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void type(String inputText, WebElement element) {
		element.sendKeys(inputText);
	}
	
	public void type(Keys enter, By locator) {
		driver.findElement(locator).sendKeys(enter);	
	}
	
	public void type(Keys enter, WebElement element) {
		element.sendKeys(enter);	
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void click(WebElement webElement) {
		webElement.click();
	}
	
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void esperaExplicita(int time, By locator) {
		WebDriverWait ewait= new WebDriverWait(driver,Duration.ofSeconds(time));
		ewait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void esperaExplicita(int time, WebElement element) {
		WebDriverWait ewait= new WebDriverWait(driver, Duration.ofSeconds(time));
		ewait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public ChromeOptions downloadTemplate() {
		String downloadPath="C:\\Users\\Usuario\\Downloads\\PruebaMandu\\Templates";
		HashMap<String, Object> chromePrefs=new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		return options;
	}

	//credenciales Brawl
	public void SignIn(By usernameLocator, By passwordLocator, By buttonLocator){
		esperaExplicita(20, usernameLocator);
		type("jeffadmin101010@yopmail.com",usernameLocator);
		type("hr123456",passwordLocator);
		esperaExplicita(20, buttonLocator);
		click(buttonLocator);			
	}
	
	public void selectSomeToDropdown(By locator, String buscado) {
		esperaExplicita(10, locator);
		List<WebElement> options=findElements(locator);
		for(int i=0; i<options.size();i++) {
			if(options.get(i).getText().equals(buscado)) {
				options.get(i).click();
			}
		}
	}

	public void visit2() {
		driver.get("https://uatsurvey.manduhr.com/login"); 
	}

	public String getValue1(By locator) {
		return driver.findElement(locator).getAttribute("innerHTML");
	}
}
