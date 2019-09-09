package SeleniumProject.TestImooc;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;

@Listeners({TestngLinstenerTakeScreenShot.class})
public class LoginTest extends BaseDriver{
	public void InitDriver() throws Exception{
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		driver =new FirefoxDriver();
		driver.get("http://www.imooc.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(2000);
	}

	
	/**
	 * 
	 * @throws Exception
	 */
	public void loginScript(String email, String password) throws Exception{
		this.InitDriver();
		WebElement usernameElement = this.element(this.byStr("username"));
		usernameElement.isDisplayed();
		WebElement passwordElement = this.element(this.byStr("password"));
		passwordElement.isDisplayed();
		WebElement loginBtn =this.element(this.byStr("LoginBtn"));
		loginBtn.isDisplayed();	
		usernameElement.sendKeys(email);
		passwordElement.sendKeys(password);
		loginBtn.click();
		Thread.sleep(5000);
		WebElement head = this.element(this.byStr("paraAvator"));
		Actions action = new Actions(driver);
		action.moveToElement(head).perform();
		WebElement name = this.element(this.byStr("paraHeadName"));
		String strName = name.getText();
		if (strName.equals("Shaviation")) {
			System.out.println("我们登陆成功了");
		}else if(strName.equals("MikeAcesse")){
			System.out.println("我们登陆成功了");
		}else {
			System.out.println("我们是失败了");
		}
		driver.close();
		
	}
/**
 * 封装By
 * @param args
 * @throws Exception
 */
	public By byStr(String key){
		ProUtil proUtil = new ProUtil("element.properties");
		String strLocator = proUtil.getPro(key);
		String locatorType = strLocator.split(">")[0];
		String locatorValue = strLocator.split(">")[1];
		if (locatorType.equals("name")) {
			return By.name(locatorValue);
		}else if (locatorType.equals("className")) {
			return By.className(locatorValue);
		}else if (locatorType.equals("id")) {
			return By.id(locatorValue);
		} else {
			return By.xpath(locatorValue);
		}
	}
	
/**
 * 重构element
 * @param args
 * @throws Exception
 */
	public WebElement element(By by){
		WebElement ele = driver.findElement(by);
	    return ele;
	}
	@Test
	public void loginPage() {
		   try {
			this.loginScript("18516233515", "Kodak1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}

	

}
