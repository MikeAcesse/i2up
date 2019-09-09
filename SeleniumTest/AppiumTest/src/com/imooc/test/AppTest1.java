package com.imooc.test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest1 {
	AndroidDriver driver;
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "3891fe8e");
		cap.setCapability("platformVersion", "5.1.1");
		cap.setCapability("appPackage", "com.android.bbkcalculator");
		cap.setCapability("appActivity", ".Calculator");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		 /*List<WebElement> editTextList =driver.findElementsByClassName("android.widget.EditText");
	    WebElement editText = editTextList.get(1);
	    editText.clear();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    WebElement editText1 =editTextList.get(0);
	    editText1.clear();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		
		
	 driver.findElementById("com.android.bbkcalculator:id/clear").click();
	 Thread.sleep(5000);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	 
	}

}
