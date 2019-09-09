package SeleniumProject.TestImooc;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
	
	WebDriver driver;
	public BaseDriver(){
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		driver =new FirefoxDriver();
	
	}
	public void close(){
		driver.close();
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


}
