package info2soft.qa.auto.pageobject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import info2soft.qa.auto.dataobject.CompareRule;
import info2soft.qa.auto.test.base.PageBase;

public class CompareManagementPage extends PageBase {

	public CompareManagementPage(WebDriver driver) {
		super(driver);
	}

	By sourceHostInput = By.xpath("//label[contains(text(),'" + sourceHostLabelStr + "')]/following-sibling::div[1]//input");
	By backupHostInput = By.xpath("//label[contains(text(),'" + backupHostLabelStr + "')]/following-sibling::div[1]//input");
	By backupPathInput = By.xpath("//table//input");
	
	By directSelect = By.xpath("//div[contains(@class, 'dialog__header')]/span[contains(text(),'" + directSelectStr + "')]");
	By dropDownSelect = By.xpath("//body/div[contains(@class, 'select-dropdown') and not(contains(@style, 'display: none'))]");
	
	By treeExpandIcon = By.xpath("//span[contains(@class,'el-tree-node__expand-icon')]");
	
	By manualInputPathTextArea = By.xpath("//p[contains(@class,'manualDialog') and contains(text(),'"
	                             + manulInputPathLabelStr +"')]/following-sibling::div[1]/textarea");

	By srcDirAddBtn = By.xpath("//button[contains(@class,'el-button el-button--primary el-button--small nodeBtn')]/span[contains(text(),'"
	                  + addBtnStr + "')]");
	By manulInputBtn = By.xpath("//span/button[2]/span[contains(text(),'" + manulInputBtnStr + "')]");
	By srcDirConfirmBtn = By.xpath("//span/button[4]/span[contains(text(),'" + confirmBtnStr + "')]");
	By backupDirConfirmBtn = By.xpath("//span/button[3]/span[contains(text(),'" + confirmBtnStr + "')]");
	//By manualInputConfirmBtn = By.xpath("//span/button[2]/span[contains(text(),'" + confirmBtnStr + "')]");
	By manualInputConfirmBtn = By.xpath("//div[contains(@aria-label, '" + manulInputBtnStr + 
            "')]/div[3]/span/button[contains(@class,'primary')]/span[contains(text(),'"
            + confirmBtnStr + "')]");

	public void createCompareRule(WebDriver driver) throws Exception {
		log("click " + createBtnStr);
		driver.findElement(createBtn).click();
		waitForPage();
	}
	
	public void configBasicSettings(WebDriver driver, CompareRule rule) throws Exception {
		String srcNode = rule.getSrcNode();
		String backNode = rule.getBackupNode();
		String srcDir = rule.getSrcDir();
		String destDir = rule.getBackupDir();
		String ruleName = rule.getName();
			
		WebElement basic = driver.findElement(basicTab);
		assertTrue(basic.isEnabled(), basicTabStr + "不可见");
		log("配置" + basicTabStr);
		log("input rule name:" + ruleName);
		driver.findElement(nameInput).sendKeys(ruleName);
		log("input source host node:" + srcNode);
		driver.findElement(sourceHostInput).click();
		Thread.sleep(1000);
				
		WebElement selectDiv = driver.findElement(dropDownSelect);
		for(WebElement select : selectDiv.findElements(By.tagName("span"))) {
			if(select.getText().equalsIgnoreCase(srcNode)) {
				select.click();
			}
		}
		
		log("input backup host node:" + backNode);
		//backupHost element can not click,but can sendkey to select
		driver.findElement(backupHostInput).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		selectDiv = driver.findElement(dropDownSelect);
		for(WebElement select : selectDiv.findElements(By.tagName("span"))) {
			if(select.getText().equalsIgnoreCase(backNode)) {
				select.click();
			}
		}

		Thread.sleep(1000);
		log("点击添加源端目录或文件");
		driver.findElement(addBtn).click();
		Thread.sleep(100);
		log("点击手动输入");
		for(WebElement manulInputBtnElement : driver.findElements(manulInputBtn)) {
			if(manulInputBtnElement.isDisplayed()) {
				manulInputBtnElement.click();
			}
		}
		log("输入 ；" + srcDir);
		for(WebElement manualInputPathTextAreaElement : driver.findElements(manualInputPathTextArea)) {
			if(manualInputPathTextAreaElement.isDisplayed()) {
				manualInputPathTextAreaElement.sendKeys(srcDir);
			}
		}
	
//		for(String dirName : srcDir.split("/")) {
//			driver.findElement(By.xpath("//span[contains(text(),'" + dirName + "')]")).click();
//		}

		log("点击确定手动输入复制的目录："  + srcDir);
		for(WebElement confirmBtn : driver.findElements(manualInputConfirmBtn)) {
			if(confirmBtn.isDisplayed()) {
				confirmBtn.click();
			}
		}
		Thread.sleep(1000);
		log("点击确定添加源端目录");
		for(WebElement srcDirConfirmBtnElement : driver.findElements(srcDirConfirmBtn)) {
			if(srcDirConfirmBtnElement.isDisplayed()) {
				srcDirConfirmBtnElement.click();
			}
		}		
		Thread.sleep(1000);
		
		log("选择添加备端目录或文件");
		log("输入备端目录" + destDir);
		WebElement backupPathInputElement = driver.findElement(backupPathInput);
		backupPathInputElement.clear();
		backupPathInputElement.sendKeys(destDir);
		
		
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
	
	public void buildCompareRule(WebDriver driver, CompareRule rule) throws Exception {
		createCompareRule(driver);
		configBasicSettings(driver, rule);
	}
}