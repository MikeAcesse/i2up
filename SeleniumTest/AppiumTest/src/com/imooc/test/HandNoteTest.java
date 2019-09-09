package com.imooc.test;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandNoteTest {
	AndroidDriver driver;

	@Before
	public void setUp() throws Exception {
        DesiredCapabilities cap=new DesiredCapabilities();		
		cap.setCapability("deviceName","192.168.57.101:5555");
		cap.setCapability("platformVersion", "7.0");
		//cap.setCapability("automationName", "Appium");
		//cap.setCapability("platformName", "Android");
		//cap.setCapability("app", "c:\\dan\\mukewang.apk");	
		//cap.setCapability("appPackage", "cn.com.open.mooc");
		//cap.setCapability("appActivity", "cn.com.open.mooc.index.splash.MCSplashActivity");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		//cap.setCapability("devicereadyTimeout", 60);
		//cap.setCapability("unicodeKeyboard", true);
		//cap.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testHandNote() throws InterruptedException {
		//enterGuide();
	}
	public void enterGuide() throws InterruptedException{
		Thread.sleep(1000);
		int width=driver.manage().window().getSize().width;
		int height=driver.manage().window().getSize().height;
		
		driver.swipe(width*3/4, height/2, width/4, height/2, 200);		
		Thread.sleep(1000);
		driver.swipe(width*3/4, height/2, width/4, height/2, 200);
		Thread.sleep(1000);
		//driver.findElementByAndroidUIAutomator("new UiSelector().text(\"马上开始\")").click();
		driver.findElementByClassName("android.widget.ImageView").click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("cn.com.open.mooc:id/icon_close").click();
		Thread.sleep(4000);
		
	}

}
