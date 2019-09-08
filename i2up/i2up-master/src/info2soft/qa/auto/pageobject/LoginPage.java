package info2soft.qa.auto.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import info2soft.qa.auto.test.base.PageBase;

public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(WebDriver driver, String username, String password) throws Exception {
		List<WebElement> a = driver.findElements(By.xpath("//input"));
		log("输入用户名： " + username);
		a.get(0).sendKeys(username);
		log("输入密码： " + password);
		a.get(1).sendKeys(password);
		log("点击登录");
		driver.findElement(By.xpath("//button[1]")).click();
		Thread.sleep(1000);//
	}
	
	public boolean isLoginSuccess(WebDriver driver) throws Exception{		
		boolean flag = false;		
		try {
			if(driver.findElement(By.xpath("//button[contains(text(),'点击进入')]")).isDisplayed()){				
				flag=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		return flag;	
	}	
	
	public boolean loginStatus(WebDriver driver) throws Exception {
		if (!(isLoginSuccess(driver))) {				
			System.out.println("用户名错误！");			
			driver.navigate().refresh();	
			Thread.sleep(2000); 			
			return false;		
		}	else {			
			System.out.println("登录成功！");
			Thread.sleep(2000);
			return true;
		}	
	} 	
	public boolean isAlertPresent(WebDriver driver) throws Exception {		
		try {			
			driver.switchTo().alert();			
			return true;		
		} catch (NoAlertPresentException e) {
			e.printStackTrace();			
			return false;
		}	
	} 	
	
	public  boolean isLoginPage(WebDriver driver) throws Exception {		
		boolean flag = false;
		try {
			driver.findElement(By.xpath("//div[text()='登 录']")).click();			
			flag = true;
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
