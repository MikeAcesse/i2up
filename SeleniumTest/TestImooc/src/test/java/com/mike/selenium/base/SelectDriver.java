package com.mike.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
	public WebDriver driverName(String browser){
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
			return new FirefoxDriver();
		
		} else {
			System.setProperty("webdriver.chrome.driver","/Users/fanzhikang/downloads/chromedriver");
			return new ChromeDriver();
		}
	}

}
