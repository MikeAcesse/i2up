package com.wcc.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends Activity {
	
	private Button btn1;
	private Button btn2;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.factivity);
		/*
		 * 初始化btn1;
		 * 
		 */
		btn1 =(Button)findViewById(R.id.button1_fisrt);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/* 
				 * 利用没有返回值的Intent 启动第二种页面
				 */
				Intent intent = new Intent(FActivity.this, SActivity.class);
			    startActivity(intent);
				
			}
		});
		btn2 =(Button)findViewById(R.id.button2_Second);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FActivity.this, SActivity.class);
				startActivityForResult(intent, 1);
				
			}
		});
		tv = (TextView) findViewById(R.id.textView1);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1&&resultCode==2) {
			String content = data.getStringExtra("mike");
			tv.setText(content);
			
		}
		
	}

}
