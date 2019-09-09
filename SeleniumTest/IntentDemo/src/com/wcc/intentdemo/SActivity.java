package com.wcc.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SActivity extends Activity{
	private Button btn;
	private String content="welcome to china";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.sactivity);
    	btn = (Button)findViewById(R.id.button1);
    	btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent data1 = new Intent();
				data1.putExtra("mike", content);
				setResult(2, data1);
				finish();
				
				
			}
		});
    
    }
    	
		
}
