
/////////////////////////////////////////
//
//     ���ã�Service
//
//     ��Ȩ�����а�Ȩ�鱱���ŲŴ��ǿƼ���˾����
//     �汾;   v1.0
//     ���ߣ� ������
//
//      ��ַ��http://www.ucai.cn
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

	// ����
	private Button start_Service, stop_Service;
	private Intent i;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		start_Service = (Button) findViewById(R.id.start);
		stop_Service = (Button) findViewById(R.id.stop);
		// ��button������
		start_Service.setOnClickListener(this);
		stop_Service.setOnClickListener(this);

		i = new Intent(ServiceDemoActivity.this, MyService.class);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			// ����Service
			startService(i);
			break;

		case R.id.stop:
			//ֹͣService
			stopService(i);
			break;
		}
	}
}