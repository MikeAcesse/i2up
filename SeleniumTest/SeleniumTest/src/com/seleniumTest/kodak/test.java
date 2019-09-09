package com.seleniumTest.kodak;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new HtmlUnitDriver();
		driver.get("http://www.baidu.com");
		System.out.println("Page title is :"+driver.getTitle());
		driver.quit();

	}

}
