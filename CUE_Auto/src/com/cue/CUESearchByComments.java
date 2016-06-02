package com.cue;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class CUESearchByComments {
	

	
	
public WebDriver driver = null;
	
    @Before
    public void beforeTest() {



   	    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://business.cueconnect.com/");
       
         
       
   
         
/*
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.cache.disk.enable", "false");
            driver = new FirefoxDriver(profile);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to("https://business.cueconnect.com/");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
         */

    }
    

	public void mouseClick(WebElement element) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'click',true,false );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
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
 
    
    @Test
	public void searchByComments() {
    	

    	WebElement signInButton = driver.findElement(By.xpath("//*[@id='imi-opensignin']"));
		delayFor(2000);
		signInButton.click();

		WebElement emailTextBox = driver.findElement(By.xpath("//*[@id='signin-email']"));
		delayFor(2000);
		emailTextBox.sendKeys("berkbowen@yahoo.com");

		WebElement passWordBox = driver.findElement(By.xpath("//*[@id='signin-password']"));
		delayFor(2000);
		passWordBox.sendKeys("specr351");

		WebElement button = driver.findElement(By.xpath("//*[@id='signin-submit']"));
		delayFor(2000);
		button.click();
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@class='search']"));
		delayFor(2000);
		mouseClick(searchButton);
		delayFor(5000);

		WebElement searchButton1 = driver.findElement(By.xpath("//*[@id='imi-search-field-fixed']/form/input"));
		delayFor(2000);
		searchButton1.sendKeys("summer");
		delayFor(2000);
		searchButton1.sendKeys(Keys.RETURN);
		delayFor(10000);
		
		driver.close();
			}
	

	

}
