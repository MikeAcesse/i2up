package SeleniumProject.TestImooc;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class Login {
	public WebDriver driver;
	public void InitDriver(){
		//设置环境变量
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		//本机firefox的profile配置
		//ProfilesIni pi = new ProfilesIni();
		//FirefoxProfile profile = pi.getProfile("default");
		//driver=new FirefoxDriver(profile);//初始化driver
		driver =new FirefoxDriver();
		driver.get("http://www.imooc.com");
		driver.manage().window().maximize();
	}

	/**
	 * 截图
	 */
	public void takeScreenShot(){
		long date =System.currentTimeMillis();
		System.out.println(date);
		String path = String.valueOf(date);
		System.out.println(path);
		String curPath =System.getProperty("user.dir");
		path =path+".png";
		String screenPath = curPath+"/"+"jpg"+"/"+path;
		File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.apache.commons.io.FileUtils.copyFile(screen, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginScript() throws Exception{
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.name("email"));
		username.isDisplayed();
		WebElement password = driver.findElement(By.name("password"));
		password.isDisplayed();
		WebElement loginBtn =driver.findElement(By.className("btn-red"));
		loginBtn.isDisplayed();
		this.takeScreenShot();
		username.sendKeys("18516233515");
		password.sendKeys("Kodak1234");
		loginBtn.click();
		Thread.sleep(2000);
		WebElement head = driver.findElement(By.id("header-avator"));
		Actions action = new Actions(driver);
		action.moveToElement(head).perform();
		WebElement name = driver.findElement(By.className("name"));
		String strName = name.getText();
		if (strName.equals("Shaviation")) {
			System.out.println("我们登陆成功了");
		}else {
			System.out.println("我们登陆失败了");
		}
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		Login login = new Login();
		login.InitDriver();
		login.loginScript();

	}

}
