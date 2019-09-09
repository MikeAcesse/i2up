package com.mike.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {
      public WebDriver driver;
      public DriverBase(String browser) {
    	  SelectDriver selectDriver = new SelectDriver();
    	  this.driver=selectDriver.driverName("firefox");
	}
      public void Stop(){
    	  System.out.println("Stop browser");
    	  driver.close();
      }
      /**
       * 封装element
       */
     public WebElement findElement(By by){
    	 WebElement element = driver.findElement(by);
    	 return element;
     }
}
