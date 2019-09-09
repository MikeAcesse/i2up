package com.seleniumTest.kodak;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class SeleniumFirefox {

	public static void main(String[] args) {
	     System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		//System.setProperty("webdriver.gecko.driver", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		WebDriver driver=new FirefoxDriver();
		String testUrl ="http://www.acesse.com";
		driver.get(testUrl);
		//driver.findElement(By.linkText("Log in")).click();
		

	}

}
