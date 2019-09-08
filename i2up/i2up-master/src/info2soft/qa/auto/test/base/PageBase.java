package info2soft.qa.auto.test.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import info2soft.qa.auto.dataobject.I2upUiStrings;
import info2soft.qa.common.model.page.PageFragment;
import info2soft.qa.common.test.GUITestCase;
import info2soft.qa.common.util.WebDriverSessionManager;

public class PageBase extends PageFragment implements I2upUiStrings {

	//Following xpath are used as general	
	public By basicTab = By.xpath("//div[@id='tab-first']");
	public By createBtn = By.xpath("//span[contains(text(),'" + createBtnStr +"')]");
	public By addBtn = By.xpath("//span[contains(text(),'" + addBtnStr + "')]");
	public By nameInput = By.xpath("//label[contains(text(),'" + nameLabelStr
			              + "')]/following-sibling::div[1]//input");
	public By confirmBtn = By.xpath("//span[contains(text(),'" + confirmBtnStr + "')]");

	public PageBase(WebDriver driver) {
		WebDriverSessionManager.getInstance().attachExternalWebDriver(driver);
	}
	
	public void waitForPage() {
		long time = 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			logger().log("catch exception during waiting page", e);
		}
	}

}
