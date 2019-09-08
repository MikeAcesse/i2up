package info2soft.qa.auto.test.base;

public class TestBase extends I2GUITestCase {


	//TestCase.setup 
	@Override
    public void setup() {
    	
    }
	
	//GUITestCaseBaseWebDriverSessionLifecycle -> TestCase.cleanup
    @Override
    public void cleanup() throws Exception {
    	//we just need to cleanup one time in afterALL, but not do it when each test done
        //final boolean silentInLog = false;
        //closeAllBrowsers(silentInLog);
    }
    
}