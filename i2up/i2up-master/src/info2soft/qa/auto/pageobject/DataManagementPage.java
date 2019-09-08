package info2soft.qa.auto.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import info2soft.qa.auto.test.base.PageBase;
import info2soft.qa.common.util.WebDriverSessionManager;

public class DataManagementPage extends PageBase {
	String enter = "//button[contains(text(),'点击进入')]";
	
	public DataManagementPage(WebDriver driver) {
		super(driver);
	}

	public void enterSummaryPage() throws Exception {
		log("点击按钮： 点击进入");
		//click(driver.findElement(enter));
		clickWebElementWithXpath(enter);
		Thread.sleep(1000);
	}

}