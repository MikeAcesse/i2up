package com.example.grid_view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	private GridView girdView;
	private SimpleAdapter adapter;
	private List<Map<String, Object>>dataList;
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		girdView = (GridView) findViewById(R.id.gridView);
		dataList = new ArrayList<Map<String,Object>>();
		adapter = new SimpleAdapter(this, getData(),R.layout.item, new String[]{"pic","name"},new int[]{R.id.pic,R.id.name});
		girdView.setAdapter(adapter);
	}
	private List<Map<String, Object>>getData(){
		int[] drawable ={R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.clock,
				R.drawable.games_control,R.drawable.ic_launcher,R.drawable.messenger,R.drawable.ringtone,
				R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,R.drawable.world,R.drawable.youtube};
		String[] iconName={ "联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
				"语音", "天气", "浏览器", "Youtube" };
		for(int i = 0; i<drawable.length;i++){
			Map<String,Object>map = new HashMap<String, Object>();
			map.put("pic", drawable[i]);
			map.put("name", iconName[i]);
			dataList.add(map);
		}
		Log.i("main", "size="+dataList.size());
		
		return dataList;
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
