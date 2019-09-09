

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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	//创建Service时，需要复写的一个方法。主要是实现与Activity进行绑定

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	//创建
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("onCreate");
	}

	//开始执行Service
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	//销毁Service
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("onDestroy");
	}

}
