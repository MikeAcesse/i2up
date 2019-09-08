package info2soft.qa.auto.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import info2soft.qa.auto.test.base.PageBase;

public class AllManagementPage extends PageBase {

	public AllManagementPage(WebDriver driver) {
		super(driver);
	}

	By summary = By.xpath("//*[contains(text(),'" + summaryStr + "')]");
	By navigateIcon = By.xpath("//aside/div/div/*[name()='svg'][1]");
	By sysManage = By.xpath("//span[contains(text(),'" + systemManageStr + 
            "')]/preceding-sibling::*[name()='svg'][1]");
	By resourceManage = By.xpath("//span[contains(text(),'" + resourceManageStr + 
			            "')]/preceding-sibling::*[name()='svg'][1]");
	By nodeManage = By.xpath("//li[contains(text(),'" + nodeManageStr + "')]");
	By ruleManage = By.xpath("//span[contains(text(),'" + ruleManageStr + 
			        "')]/preceding-sibling::*[name()='svg'][1]");
	By toolManage = By.xpath("//span[contains(text(),'" + toolManageStr + 
	                "')]/preceding-sibling::*[name()='svg'][1]");	
	//"li + text" can not work for copy rule
	By copyRule = By.xpath("//aside/div/ul/li[5]/ul/li[1]");
	By sysParameter = By.xpath("//li[contains(text(),'" + sysParameterStr + "')]");	
	By licenseManage = By.xpath("//li[contains(text(),'" + licenseManageStr + "')]");
	By compareSync = By.xpath("//li[contains(text(),'" + compareSyncStr + "')]");

	public void expandRightIcon(WebDriver driver) throws Exception {
		assertTrue(driver.findElement(summary).isEnabled(), summaryStr + "可见ʾ");
		log(summaryStr + "页面显示正常");
		driver.findElement(navigateIcon).click();
		waitForPage();
		//driver.findElement(By.id("icon-unfold")).click();
//		WebElement element = driver.findElement(By.xpath("//*[@id='app']/section/section/aside/div/ul/li[3]/div/*[name()='svg'][1]"));
//		new Actions(driver).click(element).build().perform();
//		List<WebElement> a = driver.findElements(By.xpath("//*[@id='app']//svg"));
//		a.forEach(e->System.out.println("3333 " + e.getAttribute("class")));
	}
	
	public void expandResourceManageIcon(WebDriver driver) throws Exception {
		log("点击 " + resourceManageStr);
		driver.findElement(resourceManage).click();
		//driver.findElement(By.xpath("//span[contains(text(),'资源管理')]/preceding-sibling::*[name()='svg'][1]")).click();
		//driver.findElement(By.xpath("//aside/div/ul/li[3]/div/*[name()='svg'][1]")).click();
//		driver.findElement(By.xpath("//aside/div/ul/li[3]/div/span[contains(text(),'��Դ����')]")).click();
		waitForPage();
	}
	
	public void nodeManagement(WebDriver driver) throws Exception {
		expandResourceManageIcon(driver);
		log("点击 " + nodeManageStr);
		driver.findElement(nodeManage).click();
		waitForPage();
	}

	public void expandRuleManageIcon(WebDriver driver) throws Exception {
//		expandRightIcon(driver);
		log("点击 " + ruleManageStr);
		driver.findElement(ruleManage).click();
		waitForPage();
	}
	
	public void ruleManagement(WebDriver driver) throws Exception {
		expandRuleManageIcon(driver);
		log("点击 " + copyRuleStr);
		WebElement basic = driver.findElement(copyRule);

//		JavascriptExecutor driver_js= (JavascriptExecutor) driver;
//		driver_js.executeScript("arguments[0].checked = true;", basic);
//		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", basic);
		
		basic.click();

//		Actions action = new Actions(driver);
//		action = action.moveToElement(basic);
//		Thread.sleep(10000);
//		System.out.println("Click 4444" + basic.isSelected());			
//		action.clickAndHold().build().perform();
		waitForPage();
	}
	
	public void expandSysManageIcon(WebDriver driver) throws Exception {
		log("点击 " + systemManageStr);
		driver.findElement(sysManage).click();
		waitForPage();
	}

	public void systemParameter(WebDriver driver) throws Exception {
		expandSysManageIcon(driver);
		log("点击 " + sysParameterStr);
		driver.findElement(sysParameter).click();
		waitForPage();
	}
	
	public void licenseManagement(WebDriver driver) throws Exception {
		expandSysManageIcon(driver);
		log("点击 " + licenseManageStr);
		driver.findElement(licenseManage).click();
		waitForPage();
	}
	
	public void expandToolManageIcon(WebDriver driver) throws Exception {
		log("点击 " + toolManageStr);
		driver.findElement(toolManage).click();
		waitForPage();
	}
	
	public void syncManagement(WebDriver driver) throws Exception {
		expandToolManageIcon(driver);
		log("点击 " + compareSyncStr);
		driver.findElement(compareSync).click();
		waitForPage();
	}
}
