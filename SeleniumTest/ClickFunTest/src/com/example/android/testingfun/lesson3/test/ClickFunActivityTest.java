package com.example.android.testingfun.lesson3.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.android.testingfun.lesson3.R;
import android.widget.Button;
import android.widget.TextView;
import com.example.android.testingfun.lesson3.ClickFunActivity;

public class ClickFunActivityTest extends ActivityInstrumentationTestCase2<ClickFunActivity>{

	private ClickFunActivity mClickFunActivity;
	private Button mButton;
	private TextView mTextView;
	/*public ClickFunActivityTest(Class<ClickFunActivity> activityClass) {
		super(activityClass);
		
	}*/
	public ClickFunActivityTest() {
		super(ClickFunActivity.class);
	}
	protected void setUp() {
		setActivityInitialTouchMode(true);
		mClickFunActivity=getActivity();
		mButton=(Button) mClickFunActivity.findViewById(R.id.launch_next_activity_button);
		mTextView=(TextView) mClickFunActivity.findViewById(R.id.txtview);
		
	}
	public void testPreconditions(){
		assertNotNull("mClickFunActivity is null",mClickFunActivity);
		assertNotNull("mButton is null", mButton);
		assertNotNull("mTextView is null", mTextView);
	}
	
	

}
