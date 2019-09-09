package com.mike.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mike.selenium.base.DriverBase;

public class BasePage {
     public DriverBase driver;
     public BasePage(DriverBase driver) {
    	 this.driver = driver;
	}
     /**
      * 定位Element
      * 
      */
     public WebElement element(By by){
    	 WebElement ele = driver.findElement(by);
    	 return ele;
     }
     /**
      * 封装点击
      */
     public void click(WebElement element){
    	 if (element != null) {
    		 element.click();
			
		} else {
           System.out.println("元素不存在");
		}
     }
     /**
      * 封装输入
      */
     public void sendkeys(WebElement element,String value){
    	 if (element !=null) {
    		 element.sendKeys(value);
			
		} else {
           System.out.println("输入失败+"+value);
		}
     }
     /**
      * 判断元素是否显示
      */
     public boolean assertElementIs(WebElement element){
    	 return element.isDisplayed();
     }
}
