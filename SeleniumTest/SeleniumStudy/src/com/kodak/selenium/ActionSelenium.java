package com.kodak.selenium;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import bsh.This;

public class ActionSelenium {
	public WebDriver driver;
	public void InitialDriver(){
		 //System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		 System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		String url="http://www.imooc.com/user/newlogin/from_url/";
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void inputBox(){
		driver.findElement(By.name("email")).sendKeys("18516233515");
		driver.findElement(By.name("email")).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = driver.findElement(By.name("email")).getAttribute("placeholder");
		System.out.println(s);
		driver.findElement(By.name("email")).sendKeys("18516233515");
		driver.findElement(By.name("password")).sendKeys("Kodak1234");
		driver.findElement(By.className("btn-red")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   public void raidoBox(){
	   driver.get("http://www.imooc.com/user/setprofile");
	   driver.findElement(By.linkText("编辑")).click();
	   //driver.findElement(By.xpath(".//*[@id='profile']/div[4]/div/label[2]")).click();
	   List<WebElement> labels=driver.findElements(By.xpath(".//*[@id='profile']/div[4]/div//label"));
	   System.out.println(labels.size());
	   for (WebElement webElement : labels) {
		 boolean flag = webElement.isSelected();
		 if (flag==false) {
			 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     webElement.click();
		     break;
		}else {
			System.out.println(labels.size());
		}
	}
	  driver.findElement(By.xpath(".//*[@id='profile-submit']")).click();
   }
   public void checkBox(){
	 WebElement checkbox=  driver.findElement(By.id("auto-signin"));
	 System.out.println("checkbox keyong:"+checkbox.isEnabled());
	 //System.out.println(checkbox.isSelected());
	 try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 checkbox.click();
   }
   public void login(){
	   try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   driver.findElement(By.className("btn-red")).click();
   }
   public void webForm(){
	   driver.findElement(By.id("signup-form")).submit();
   }
   public void inputBox1(){
	   driver.get("http://www.imooc.com/");
	   driver.findElement(By.linkText("登录")).click();
	   driver.findElement(By.name("email")).sendKeys("18516233515");
	   driver.findElement(By.name("password")).sendKeys("Kodak1234");
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   /**
    * 上传文件
    * @param args
    */
   public void uploadheader(){
	   driver.get("http://www.imooc.com/user/setbindsns");
	   try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   String jsString ="document.getElementsByClassName('update-avator')[0].style.bottom='0';";
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript(jsString);
	   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   driver.findElement(By.className("js-avator-link")).click();
	 
	   driver.findElement(By.id("upload")).sendKeys("//Users//fanzhikang//desktop//pic.jpg");
	   
	   
	   
	   
	   
   }
   /**
    * 鼠标事件
    * @param args
    */
	public static void main(String[] args) {
		ActionSelenium as =new ActionSelenium();
		as.InitialDriver();
		as.inputBox();
		//as.inputBox1();
		//as.raidoBox();
		//as.checkBox();
		 // as.login();
		//as.webForm();
		as.uploadheader();
		

	}

}
