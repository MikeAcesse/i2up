

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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	//����Serviceʱ����Ҫ��д��һ����������Ҫ��ʵ����Activity���а�

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	//����
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("onCreate");
	}

	//��ʼִ��Service
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	//����Service
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("onDestroy");
	}

}
