package info2soft.qa.auto.pageobject;


import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import info2soft.qa.auto.dataobject.CopyRule;
import info2soft.qa.auto.dataobject.Node;
import info2soft.qa.auto.test.base.PageBase;
import info2soft.qa.common.util.WebDriverSessionManager;

public class RuleManagementPage extends PageBase {

	By pathTab = By.xpath("//div[contains(text(),'" + pathTabStr + "')]");
	By sourceHost = By.xpath("//label[contains(text(),'" + sourceHostLabelStr + "')]/following-sibling::div[1]//input");
	By backupHost = By.xpath("//label[contains(text(),'" + backupHostLabelStr + "')]/following-sibling::div[1]//input");
	
	By mapTypeLabel = By.xpath("//label[contains(text(),'" + mapTypeStr + "')]");
	By mapTypeLabel1 = By.xpath("//label/span[contains(text(),'" + mapTypeStr1 + "')]");
	By mapTypeLabel2 = By.xpath("//label/span[contains(text(),'" + mapTypeStr2 + "')]");
	
	By directSelect = By.xpath("//div[contains(@class, 'dialog__header')]/span[contains(text(),'" + directSelectStr + "')]");
	By dropDownSelect = By.xpath("//body/div[contains(@class, 'select-dropdown') and not(contains(@style, 'display: none'))]");
	
	By treeExpandIcon = By.xpath("//span[contains(@class,'el-tree-node__expand-icon')]");

	By backupPathInput = By.xpath("//table//input");
	
	String manualInputPathTextArea = "//p[contains(@class,'manualDialog') and contains(text(),'"
            + manulInputPathLabelStr +"')]/following-sibling::div[1]/textarea";
	
	By addBtn = By.xpath("//span[contains(text(),'" + addBtnStr + "')]");
	By srcDirAddBtn = By.xpath("//button[contains(@class,'el-button el-button--primary el-button--small nodeBtn')]/span[contains(text(),'"
	                  + addBtnStr + "')]");
	String manulInputBtn = "//span/button[2]/span[contains(text(),'" + manulInputBtnStr + "')]";
	String srcDirConfirmBtn = "//span/button[4]/span[contains(text(),'" + confirmBtnStr + "')]";
	By backupDirConfirmBtn = By.xpath("//span/button[3]/span[contains(text(),'" + confirmBtnStr + "')]");
	String manualInputConfirmBtn = "//div[contains(@aria-label, '" + manulInputBtnStr + 
			                   "')]/div[3]/span/button[contains(@class,'primary')]/span[contains(text(),'"
			                   + confirmBtnStr + "')]";
	
	public RuleManagementPage(WebDriver driver) {
		super(driver);
	}

	public void createNewRule(WebDriver driver) throws Exception {
		log("click " + createBtnStr);
		driver.findElement(createBtn).click();
		waitForPage();
	}
	
	public void configBasicSettings(WebDriver driver, CopyRule rule) throws Exception {
		String srcNode = rule.getSrcNode();
		String backNode = rule.getBackupNode();
		String ruleName = rule.getName();
		
		WebElement basic = driver.findElement(basicTab);
		assertTrue(basic.isEnabled(), basicTabStr + "可见");
		log("配置" + basicTabStr);
		log("input rule name:" + ruleName);
		driver.findElement(nameInput).sendKeys(ruleName);
		log("input source host node:" + srcNode);
		driver.findElement(sourceHost).click();
		Thread.sleep(1000);
		
		WebElement selectDiv = driver.findElement(dropDownSelect);
		for(WebElement select : selectDiv.findElements(By.tagName("span"))) {
			if(select.getText().equalsIgnoreCase(srcNode)) {
				select.click();
			}
		}
		
		log("input backup host node:" + backNode);
		//backupHost element can not click,but can sendkey to select
		driver.findElement(backupHost).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		selectDiv = driver.findElement(dropDownSelect);
		for(WebElement select : selectDiv.findElements(By.tagName("span"))) {
			if(select.getText().equalsIgnoreCase(backNode)) {
				select.click();
			}
		}
		driver.findElement(pathTab).click();
		waitForPage();
	}
	
	public void configPathSettings(WebDriver driver, CopyRule rule) throws Exception {
		String srcDir = rule.getSrcDir();
		String destDir = rule.getBackupDir();
		String mapType = rule.getMapType();
		String ruleName = rule.getName();
		
		WebElement pathTab = driver.findElement(mapTypeLabel);
		assertTrue(pathTab.isEnabled(), "路径设置可见");
		log("映射类型："  + mapType);
		if(mapType.equalsIgnoreCase(mapTypeStr1)) {
			driver.findElement(mapTypeLabel1).click();
		} else if(mapType.equalsIgnoreCase(mapTypeStr2)) {
			driver.findElement(mapTypeLabel2).click();
		}		
		
		Thread.sleep(1000);
		log("点击添加源端目录或文件");
		driver.findElement(addBtn).click();
		Thread.sleep(2000);
		log("点击手动输入");
		clickDisplayedElement(manulInputBtn);

		Thread.sleep(1000);
		log("输入 ；" + srcDir);
		getDisplayedElementWithXpath(manualInputPathTextArea).sendKeys(srcDir);
		log("点击确定手动输入复制的目录："  + srcDir);
		Thread.sleep(1000);
		
		getDisplayedElementWithXpath(manualInputConfirmBtn).click();

		Thread.sleep(1000);
		log("点击确定添加源端目录");
		
		getDisplayedElementWithXpath(srcDirConfirmBtn).click();
		
		log("选择添加备端目录或文件");
		log("输入备端目录" + destDir);
		WebElement backupPathInputElement = driver.findElement(backupPathInput);
		backupPathInputElement.clear();
		backupPathInputElement.sendKeys(destDir);
		
		Thread.sleep(1000);
		log("点击确定添加规则");
		driver.findElement(confirmBtn).click();
		//wait 30s
		Thread.sleep(30000);
		WebElement statusElement = driver.findElement(By.xpath("//div[contains(text(),'"
		                           + ruleName + "')]/../following-sibling::td[1]/div/div/span"));
		String status = statusElement.getText();
		log(ruleName + "规则的状态目前是 ：" + status);
	}
	
	public void configPathSettingsByDirTree(WebDriver driver, CopyRule rule) throws Exception {
		String srcDir = rule.getSrcDir();
		String destDir = rule.getBackupDir();
		String mapType = rule.getMapType();
		String ruleName = rule.getName();
		
		WebElement pathTab = driver.findElement(mapTypeLabel);
		assertTrue(pathTab.isEnabled(), "路径设置可见");
		log("配置路径设置");
		log("映射类型："  + mapType);
		if(mapType.equalsIgnoreCase(mapTypeStr1)) {
			driver.findElement(mapTypeLabel1).click();
		} else if(mapType.equalsIgnoreCase(mapTypeStr2)) {
			driver.findElement(mapTypeLabel2).click();
		}
		log("点击添加源端目录或文件");
		driver.findElement(addBtn).click();	

//		WebElement dialogRoot = driver.findElement(By.xpath("//body/div[contains(@class,'dialog__wrapper')]/div"));
//		for(WebElement e : driver.findElements(directSelect)) {
//			if(e.isDisplayed()) {
//				dialogRoot = e;
//			}
//		}

		log("展开源端目录树");
		driver.findElement(treeExpandIcon).click();
		Thread.sleep(100);
		log("选择要复制的目录 ："  + "test");
		driver.findElement(By.xpath("//span[contains(text(),'test')]")).click();
		log("添加要复制的目录："  + "test");
		driver.findElement(srcDirAddBtn).click();
		log("点击确定添加源端目录");
		driver.findElement(By.xpath(srcDirConfirmBtn)).click();

		log("选择添加备端目录或文件");
		Thread.sleep(1000);	
		for(WebElement btn : driver.findElements(By.xpath("//button[contains(@title,'选择路径')]"))) {
			if(btn.isDisplayed()) {
				btn.click();
			}
		}
		log("展开备端目录树");
		driver.findElement(treeExpandIcon).click();
		Thread.sleep(100);
		log("选择要复制的目录 ："  + "whbtest");
		driver.findElement(By.xpath("//span[contains(text(),'whbtest')]")).click();
		Thread.sleep(100);
		log("点击确定添加备端目录");
		driver.findElement(backupDirConfirmBtn).click();
		Thread.sleep(1000);
		log("点击确定添加规则");
		driver.findElement(confirmBtn).click();
		//wait 1min
		Thread.sleep(60000);
		WebElement statusElement = driver.findElement(By.xpath("//div[contains(text(),'"
		                           + ruleName + "')]/../following-sibling::td[1]/div/div/span"));
		String status = statusElement.getText();
		log(ruleName + "规则的状态目前是 ：" + status);
	}
	
	public void buildCopyRule(WebDriver driver, CopyRule rule) throws Exception {
		createNewRule(driver);
		configBasicSettings(driver, rule);
		configPathSettings(driver, rule);
	}
}