package com.example.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	 private GridView gridView;
	 private SimpleAdapter adapter;
	 private List<Map<String,Object>> dataList;
	 int[]pic={ R.drawable.address_book, R.drawable.calendar,
				R.drawable.camera, R.drawable.clock, R.drawable.games_control,
				R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
				R.drawable.speech_balloon, R.drawable.weather,
				R.drawable.world, R.drawable.youtube };
	String[] iconName = { "联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
				"语音", "天气", "浏览器", "Youtube" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView)findViewById(R.id.gridView);
		dataList = new ArrayList<Map<String,Object>>();

		adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","iconName"}, new int[]{R.id.imageView,R.id.textView});
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}

	private List<Map<String, Object>> getData(){
		
		
		for(int i=0;i<pic.length;i++)
		{
			Map<String,Object>map = new HashMap<String, Object>();
			map.put("pic", pic[i]);
			map.put("text", iconName[i]);
			dataList.add(map);
			
		}
		return dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "我是"+iconName[arg2], Toast.LENGTH_SHORT).show();
		
	}

	
}
