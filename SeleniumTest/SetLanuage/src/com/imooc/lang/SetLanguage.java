package com.imooc.lang;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SetLanguage extends UiAutomatorTestCase {
	
	public void SetChinese() throws UiObjectNotFoundException{
		UiObject app =new UiObject(new UiSelector().description("Apps"));
		app.clickAndWaitForNewWindow();
		
		UiObject setting = new UiObject(new UiSelector().text("Settings"));
		setting.clickAndWaitForNewWindow();
		
		UiScrollable scroll = new UiScrollable(new UiSelector().resourceId("com.android.settings:id/dashboard_container"));
		
	}

	public static void main(String[] args) {
		

	}

}
