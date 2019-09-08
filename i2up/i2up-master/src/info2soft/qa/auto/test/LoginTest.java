package info2soft.qa.auto.test;

import info2soft.qa.auto.pageobject.DataManagementPage;
import info2soft.qa.auto.pageobject.LicenseManagementPage;
import info2soft.qa.auto.pageobject.LoginPage;
import info2soft.qa.auto.pageobject.NodeManagementPage;
import info2soft.qa.auto.pageobject.RuleManagementPage;
import info2soft.qa.auto.pageobject.SystemParameterPage;
import info2soft.qa.auto.test.base.TestBase;
import info2soft.qa.Depend;
import info2soft.qa.auto.dataobject.CompareRule;
import info2soft.qa.auto.dataobject.CopyRule;
import info2soft.qa.auto.dataobject.Node;
import info2soft.qa.auto.pageobject.AllManagementPage;
import info2soft.qa.auto.pageobject.CompareManagementPage;
import info2soft.qa.auto.util.JsonUtil;

public class LoginTest extends TestBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginPage loginPage = new LoginPage(driver);
	private AllManagementPage allManagementPage = new AllManagementPage(driver);
	
	public void loginTest() throws Exception {
		logger.testStart("用户登录", "验证登陆账号正确");
		if(loginPage.isLoginPage(driver)){	
			try {
				logger.logStep("开始登录");
				loginPage.login(driver, getAdminUser(), getAdminPwd());
			} catch (Exception e) {
				reportFail("用户登录异常", e);
			} finally {
				//assertEquals(false, loginPage.loginStatus(driver));
			}
		}
		logger.testEnd("用户登录");
	}
	
	@Depend("loginTest")
	public void enterSummaryPage() throws Exception {
		logger.testStart("总览和导航页面", "验证总览和导航页面打开和显示正确");
		DataManagementPage dataManagementPage = new DataManagementPage(driver);
		logger.logStep("Click 点击进入");
		dataManagementPage.enterSummaryPage();
		logger.logStep("导航菜单打开正常");
		allManagementPage.expandRightIcon(driver);
		logger.testEnd("总览和导航页面");
	}
	
	@Depend("enterSummaryPage")
	public void enterSysParaManage() throws Exception {
		logger.testStart("点击系统管理和系统参数", "验证系统参数页面正确");
		allManagementPage.systemParameter(driver);
		logger.testEnd("系统参数页面");
	}
	
	@Depend("enterSysParaManage")
	public void updateSysParas() throws Exception {
		logger.testStart("更新系统配置", "验证修改全局设置正确");
		SystemParameterPage systemParameterPage = new SystemParameterPage(driver);
		systemParameterPage.updateGlobalSettings(driver, getCentctlIp());
		logger.testEnd("修改全局设置");
	}
	
	@Depend("updateSysParas")
	public void enterNodeManage() throws Exception {
		logger.testStart("节点管理页面", "验证节点管理页面打开正确");
		allManagementPage.nodeManagement(driver);		
		logger.testEnd("节点管理页面");
	}
	
	@Depend("enterNodeManage")
	public void createNode() throws Exception {
		logger.testStart("新建节点", "验证新建节点正确");
		NodeManagementPage nodeManagementPage = new NodeManagementPage(driver);
		for(Node node : getNodes()) {
			nodeManagementPage.buildNode(driver, node);
		}
		logger.testEnd("新建节点");
	}

	@Depend("createNode")
	public void enterLicenseManage() throws Exception {
		logger.testStart("许可管理页面", "验证许可管理页面打开正确");
		logger.logStep("input license text");
		allManagementPage.licenseManagement(driver);
		logger.testEnd("许可管理页面");
	}
	
	@Depend("enterLicenseManage")
	public void addLicense() throws Exception {
		LicenseManagementPage licenseManagementPage = new LicenseManagementPage(driver);
		logger.testStart("添加许可", "验证添加许可正确");
		licenseManagementPage.addLicense(driver);
		licenseManagementPage.uploadLicense(driver);
		logger.logStep("点击coopy 查看去绑定node : ");
		licenseManagementPage.bindCoopyNodeToLicense(driver, getNodeNames());
		logger.logStep("点击关闭");
		logger.testEnd("添加许可");
	}
	
	@Depend("addLicense")
	public void enterRuleManage() throws Exception {
		logger.testStart("访问复制规则", "验证访问复制规则正确");
		allManagementPage.ruleManagement(driver);
		logger.testEnd("复制规则");
	}
	
	@Depend("enterRuleManage")
	public void createCopyRules() {
		logger.testStart("新建规则", "验证新建规则正确");
		RuleManagementPage ruleManagementPage = new RuleManagementPage(driver);
		for(CopyRule rule : getCopyRules()) {
			try {
				ruleManagementPage.buildCopyRule(driver, rule);
			} catch (Exception e) {
				reportFail("Fail to create copy rule");
				//testcase.reportFail is not work well.
				//reportFail("Fail to create copy rule with exception",e);
				logger.log("Fail to create copy rule",e);
			}
		}
		logger.testEnd("新建规则");
	}
	
	@Depend("createCopyRules")
	public void enterToolManage() throws Exception {
		logger.testStart("点击实用工具和比较同步", "验证比较同步页面正确");
		allManagementPage.syncManagement(driver);
		logger.testEnd("比较同步页面");
	}
	
	@Depend("enterToolManage")
	public void createCompareRules() throws Exception {
		logger.testStart("新建比较规则", "验证比较规则正确");
		CompareManagementPage compareManagementPage = new CompareManagementPage(driver);
		for(CompareRule rule : getCompareRules()) {
			compareManagementPage.buildCompareRule(driver, rule);
		}
		//compareManagementPage.configBasicSettings(driver, getNodeNames().toArray(new String[0]));
		logger.testEnd("新建比较规则");
	}
}