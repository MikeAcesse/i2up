package info2soft.qa.auto.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import info2soft.qa.auto.dataobject.Node;
import info2soft.qa.auto.test.base.PageBase;

public class NodeManagementPage extends PageBase {

	public NodeManagementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By manageAddressInput = By.xpath("//label[contains(text(),'" + manageAddressLabelStr
			                + "')]/following-sibling::div[1]//input");
	By managePortInput = By.xpath("//label[contains(text(),'" + managePortlabelStr + 
			             "')]/following-sibling::div[1]//input");
	By dataAddressInput = By.xpath("//label[contains(text(),'" + dataAddresslabelStr + 
			         "')]/following-sibling::div[1]//input");
	By userNameInput = By.xpath("//label[contains(text(),'" + userNamelabelStr + 
			      "')]/following-sibling::div[1]//input");
	By pwdInput = By.xpath("//label[contains(text(),'" + pwdlabelStr + 
			      "')]/following-sibling::div[1]//input");
	By authBtn = By.xpath("//label[contains(text(),'" + pwdlabelStr + 
			     "')]/following-sibling::div[1]//button/span[contains(text(),'" + authBthStr + "')]");
	By noteTextArea = By.xpath("//label[contains(text(),'" + noteLabelStr + 
			          "')]/following-sibling::div[1]//textarea");
	
	public void createNewNode(WebDriver driver) throws Exception {
		log("click " + createBtnStr);
		driver.findElement(createBtn).click();
		waitForPage();
	}
	
	public void configBasicSettings(WebDriver driver, Node node) throws Exception {
		String nodeName = node.getName();
	
		WebElement basic = driver.findElement(basicTab);
		assertTrue(basic.isEnabled(), "基本设置可见");
		log("config basic settings");
		
		log("input " + nameLabelStr + " : " + nodeName);
		driver.findElement(nameInput).sendKeys(nodeName);
		log("input " + manageAddressLabelStr + " : " + node.getCcIp());
		driver.findElement(manageAddressInput).sendKeys(node.getCcIp());
		log("input " + managePortlabelStr + " : " + node.getPort());
		WebElement managePortElement = driver.findElement(managePortInput);
		managePortElement.clear();
		managePortElement.sendKeys(node.getPort());
		log("input " + dataAddresslabelStr + " : " + node.getDataIp());
		driver.findElement(dataAddressInput).sendKeys(node.getDataIp());
		log("input " + userNamelabelStr + " : " + node.getUser());
		driver.findElement(userNameInput).sendKeys(node.getUser());
		log("input " + pwdlabelStr + " : " + node.getPwd());
		driver.findElement(pwdInput).sendKeys(node.getPwd());
		log("点击" + authBthStr);
		driver.findElement(authBtn).click();

		Thread.sleep(100);
		WebElement notes = driver.findElement(noteTextArea);
//		ActionChains(driver).move_to_element(notes).perform();
		JavascriptExecutor driver_js= (JavascriptExecutor) driver;
        //driver_js.executeScript("document.getElementById(\"kw\").value=\"selenium\"");
        //driver.findElement(By.id("su")).click();
        //waitForElementToLoad(driver, 10, By.xpath(".//*[@id='container']/div[2]/div/div[2]"));
		driver_js.executeScript("arguments[0].scrollIntoView(true)", notes);
		log("输入备注 ：" + node.getNote());
		notes.sendKeys(node.getNote());
		Thread.sleep(1000);
		log("点击" + confirmBtnStr + "添加节点");
		driver.findElement(confirmBtn).click();
//		WebElement monitor = driver.findElement(By.xpath("//*[@id='tab-third']"));
//		monitor.click();
		//wait 20s
		Thread.sleep(20000);
		WebElement statusElement = driver.findElement(By.xpath("//div[contains(text(),'"
		                           + nodeName + "')]/../following-sibling::td[1]/div/div/span"));
		String status = statusElement.getText();
		log(nodeName + "节点的状态目前是 ：" + status);
		
	}
	
	public void buildNode(WebDriver driver, Node node) throws Exception {
		createNewNode(driver);
		configBasicSettings(driver, node);
	}
}