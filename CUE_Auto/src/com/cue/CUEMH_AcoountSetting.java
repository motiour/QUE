package com.cue;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

public class CUEMH_AcoountSetting {

	public WebDriver driver = null;

	@Before
	public void beforeTest() throws SecurityException, IOException {

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://business.cueconnect.com/");

		/*
		 * 
		 * FirefoxProfile profile = new FirefoxProfile();
		 * profile.setPreference("browser.cache.disk.enable", "false"); driver =
		 * new FirefoxDriver(profile);
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 * driver.navigate().to("https://business.cueconnect.com/");
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * 
		 * 
		 */

	}

	public void delayFor(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void afterTest() {

		driver.close();
	}

	public void hoverItem(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void hoverItem(By by) {
		WebElement element = driver.findElement(by);
		hoverItem(element);
	}

	public void hoverItemEx(WebElement element) {
		Locatable hoverItem = (Locatable) element;
		Mouse mouse = ((HasInputDevices) driver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
	}

	public void hoverItemEx(By by) {
		WebElement element = driver.findElement(by);
		hoverItemEx(element);
	}

	public void mouseClick(WebElement element) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'click',true,false );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
	}

	public void mouseOver(WebElement element) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
	}

	@Test
	public void CUEMH_AcoountSettings() {

		WebElement signInButton = driver.findElement(By.xpath("//*[@id='imi-opensignin']"));
		delayFor(2000);
		signInButton.click();

		WebElement emailTextBox = driver.findElement(By.xpath("//*[@id='signin-email']"));
		delayFor(2000);
		emailTextBox.sendKeys("miclue@cueconnect.com");

		WebElement passWordBox = driver.findElement(By.xpath("//*[@id='signin-password']"));
		delayFor(2000);
		passWordBox.sendKeys("yecru3r");

		WebElement button = driver.findElement(By.xpath("//*[@id='signin-submit']"));
		button.click();
		delayFor(20000);

	
		WebElement actImpTab = driver.findElement(By.xpath("//*[@id='imi-app']/body/div[2]/div[1]/ul/li[3]/a"));
		actImpTab.click();
		delayFor(2000);

		WebElement corporateTab = driver.findElement(By.xpath(".//*[@id='imi-app']/body/div[2]/div[1]/ul/li[3]/ul/li[2]/a"));
		corporateTab.click();
		delayFor(2000);

		WebElement storeTab = driver.findElement(By.xpath(".//*[@id='imi-app']/body/div[2]/div[1]/ul/li[3]/ul/li[3]/a"));
		storeTab.click();
		delayFor(2000);

		WebElement billingTab = driver.findElement(By.xpath(".//*[@id='imi-app']/body/div[2]/div[1]/ul/li[3]/ul/li[4]/a"));
		billingTab.click();
		delayFor(2000);

		
		driver.close();

	}

}
