package info2soft.qa.auto.test.base;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import info2soft.qa.auto.dataobject.CompareRule;
import info2soft.qa.auto.dataobject.CopyRule;
import info2soft.qa.auto.dataobject.Node;
import info2soft.qa.auto.util.JsonUtil;
import info2soft.qa.common.configuration.AutomationClientEnvironment;
import info2soft.qa.common.test.GUITestCase;


public class I2GUITestCase extends GUITestCase{
	protected WebDriver driver = null;
	protected JSONObject testData = null;

	@Override
	protected void setupBeforeAllSuites() {
		String jsonTestDataFileName = AutomationClientEnvironment.folders.inputData() + "TestData.json";
		try {
			//JsonUtil.loadProperties();
			logger.log("load test data from file: " + jsonTestDataFileName);
	    	testData = JsonUtil.loadInfoJson(jsonTestDataFileName);
		} catch (Exception e) {
			logger.log("Fail to load file: " + jsonTestDataFileName, e);
		}		
		openI2up();
	}

	private void openI2up() {
		String URL = "";
		try {
			super.setup();
			URL = "https://" + getCentctlIp() + ":" + getCentctlPort();			
			openURL(URL);	
			logger.log("Open url: " + URL);
			driver = (WebDriver) driver();
		} catch (Exception e) {
			logger.log("Fail to open: " + URL,e);
		}
	}
	
	protected String getAdminUser() {
		return (String) testData.get(JsonUtil.CENTCTL_USER);
	}
	
	protected String getAdminPwd() {
		return (String) testData.get(JsonUtil.CENTCTL_PWD);
	}
	
	protected String getCentctlIp() {
		return (String) testData.get(JsonUtil.CENTCTL_IP);
	}
	
	protected String getCentctlPort() {
		return (String) testData.get(JsonUtil.CENTCTL_PORT);
	}
	
	protected List<Node> getNodes() {
		return JsonUtil.getNodeInfo(testData);
	}
	
	protected List<String> getNodeNames() {
		List<String> nodeNames = new ArrayList<String>();
		for(Node node : getNodes()) {
			nodeNames.add(node.getName());
		}
		return nodeNames;
	}
	
	protected List<CopyRule> getCopyRules() {
		return JsonUtil.getCopyRuleInfo(testData);
	}
	
	protected List<CompareRule> getCompareRules() {
		return JsonUtil.getCompareRuleInfo(testData);
	}
	
	@Override
	public void afterAll() throws Exception {
		//url open in method run threa, but afterAll called in case run thread, 
		//so WebDriverSessionManager can not be called in afterAll.
		Thread.sleep(60000);
		//driver.quit();
		//SeleniumUtil.forceDownWebDriver(driver);
	}
}
