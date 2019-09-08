package info2soft.qa.auto.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import info2soft.qa.auto.test.base.PageBase;
import info2soft.qa.common.configuration.AutomationClientEnvironment;
import info2soft.qa.common.util.FileSystemUtil;

public class LicenseManagementPage extends PageBase {

	public LicenseManagementPage(WebDriver driver) {
		super(driver);
	}

	private By textArea = By.xpath("//div/textarea");
	private By coopyXpath = By.xpath("//div[contains(text(),'coopy')]");
	private By coopyCheckBtn = By.xpath("//div[text()='coopy']/../..//button/span[contains(text(),'" 
	                           + checkStr + "')]");
	//关闭button为default不可见
	//private By closeBtn = By.xpath("//button/span[contains(text(),'关闭')]");
	private By closeBtn = By.xpath("//*[contains(text(),'许可证绑定情况')]/following-sibling::button[1]/i");
	private By refreshBindBtn = By.xpath("//div/button[2]/span[contains(text(),'" + refreshBindStr + "')]");
	
	
	public void addLicense(WebDriver driver) throws Exception {
		log("点击" + addBtnStr);
		driver.findElement(addBtn).click();
		waitForPage();
	}
	
	public void uploadLicense(WebDriver driver) throws Exception {
		String licenseFilePath = AutomationClientEnvironment.folders.upload() + "license.txt";
		String license = FileSystemUtil.readFile(licenseFilePath);
		//ignore license text because it is too big
		//logger.log(license);
		driver.findElement(textArea).sendKeys(license);
		log("点击确定");		
		driver.findElement(confirmBtn).click();
		log("Uploading license to server in 30s");
		Thread.sleep(30000);
	}
	
	public void bindCoopyNodeToLicense(WebDriver driver, List<String> nodeNames) throws Exception {
		driver.findElement(coopyCheckBtn).click();
		JavascriptExecutor driver_js= (JavascriptExecutor) driver;
		boolean hasNewNode = false;
		for(String nodeName : nodeNames) {
			WebElement nodeStatus = driver.findElement(By.xpath("//div[contains(text(),'" + 
		                            nodeName + "')]/../../td[5]/div/p"));
			if(nodeStatus.getText().equalsIgnoreCase("否")) {
				log("节点" + nodeName + "没有绑定");
				hasNewNode = true;
				WebElement chkBox = driver.findElement(By.xpath("//div[contains(text(),'" + 
				                    nodeName + "')]/../..//input"));
				driver_js.executeScript("arguments[0].setAttribute('aria-hidden','false')", chkBox);
				Thread.sleep(500);
				log("选择节点" + nodeName);
				driver_js.executeScript("arguments[0].click();", chkBox);			
			} else {
				log("节点" + nodeName + "已经绑定");
			}
		}
		if(hasNewNode) {
			log("点击更新绑定");
			driver.findElement(refreshBindBtn).click();
			Thread.sleep(1000);
		}
		for(String nodeName:nodeNames) {
			WebElement nodeStatus = driver.findElement(By.xpath("//div[contains(text(),'" + 
		                            nodeName + "')]/../../td[5]/div/p"));
			log("节点" + nodeName + "当前绑定状态 : " + nodeStatus.getText());
		}
		driver.findElement(closeBtn).click();
		Thread.sleep(1000);

//			//driver.findElement(By.xpath("//div[contains(text(),'" + nodeName + "')]/../..//input[@type='checkbox']")).click();
//			WebElement chkBox = driver.findElement(By.xpath("//div[contains(text(),'" + nodeName + "')]/../..//input"));
//			//WebElement chkBox = driver.findElement(By.xpath("//div[contains(text(),'" + nodeName + "')]/../preceding-sibling::td[1]/div/label/span/input"));
//			//WebElement chkBox = driver.findElement(By.xpath("//main/div/section/div[2]/div[5]/div/div[2]/div/div[3]/table/tbody/tr[2]/td[1]/div/label/span/input"));
//			//driver.findElements(By.xpath("//input[@type='checkbox']")).forEach(e->e.click());
//			
//            //String js = "document.getElementById(\"signOut\").style.display=\"block\"";//将display属性修改为block的js代码		
//            //((JavascriptExecutor) fd).executeScript(js);//执行js
//			JavascriptExecutor driver_js= (JavascriptExecutor) driver;
//			//driver_js.executeScript("arguments[0].aria-hidden=arguments[1]", chkBox, "false");
//			driver_js.executeScript("arguments[0].setAttribute('aria-hidden','false')", chkBox);
//			//driver_js.executeScript("arguments[0].removeAttribute('aria-hidden')", chkBox);
//			//driver_js.executeScript("arguments[0].aria-hidden=arguments[1]", chkBox, "false");
//			Thread.sleep(500);
//			logger.logStep("选择节点" + nodeName);
//			driver_js.executeScript("arguments[0].click();", chkBox);
//			logger.logStep("点击更新绑定");
//			driver.findElement(refreshBindBtn).click();
	}
}