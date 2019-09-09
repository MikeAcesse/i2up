package SeleniumProject.TestImooc;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngLinstenerTakeScreenShot extends TestListenerAdapter {
	@Override
	public void onTestSuccess(ITestResult tr){
		super.onTestSuccess(tr);
		this.TakeScreenshot(tr);
	}
	@Override
	public void onTestFailure(ITestResult tr){
		super.onTestFailure(tr);
		TakeScreenshot(tr);
		
	}
	public void TakeScreenshot(ITestResult tr){
		BaseDriver b= (BaseDriver)tr.getInstance();
		b.takeScreenShot();
		b.close();
	}
	@Override
	public void onTestSkipped(ITestResult tr){
		super.onTestSkipped(tr);
	}
	@Override
	public void onStart(ITestContext testContext){
		super.onStart(testContext);
	}
	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
	  }
	
}
