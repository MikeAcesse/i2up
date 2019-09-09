
/////////////////////////////////////////
//
//     作用：Service
//
//     版权：所有版权归北京优才创智科技公司所有
//     版本;   v1.0
//     作者： 刘兴宇
//
//      网址：http://www.ucai.cn
//
/////////////////////////////////////////


package cn.ucai.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceDemoActivity extends Activity implements OnClickListener {

	// 声明
	private Button start_Service, stop_Service;
	private Intent i;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		start_Service = (Button) findViewById(R.id.start);
		stop_Service = (Button) findViewById(R.id.stop);
		// 给button做监听
		start_Service.setOnClickListener(this);
		stop_Service.setOnClickListener(this);

		i = new Intent(ServiceDemoActivity.this, MyService.class);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			// 启动Service
			startService(i);
			break;

		case R.id.stop:
			//停止Service
			stopService(i);
			break;
		}
	}
}