package info2soft.qa.auto.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import info2soft.qa.auto.test.base.PageBase;

public class SystemParameterPage extends PageBase {
	
	public SystemParameterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By manageIpInput = By.xpath("//label[contains(text(),'" + manageIpLabelStr + "')]/following-sibling::div[1]//input");
	By updateGlobalSetBtn = By.xpath("//span[contains(text(),'" + updateGlobalSetBtnStr + "')]");
	
	public void updateGlobalSettings(WebDriver driver, String manageIP) throws Exception {
		log("输入 " + manageIpLabelStr + ": " + manageIP);
		driver.findElement(manageIpInput).clear();
		driver.findElement(manageIpInput).sendKeys(manageIP);
		log("点击 " + updateGlobalSetBtnStr);
		driver.findElement(updateGlobalSetBtn).click();
		Thread.sleep(5000);
	}
}
