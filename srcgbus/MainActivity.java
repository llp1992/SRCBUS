package com.example.srcgbus;

//import android.R;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	// private ListView listview;
	private List<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		ActionBar bar = getActionBar();
//		bar.show();

		// 设置各种路线
		list.add("天河城线");
		list.add("天河公园线");
		list.add("大学城线");
		ListView listview = (ListView) findViewById(R.id.listofroute);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		// 设置列表的点击监听事件
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String NameOfRoute = (String) list.get(position).toString();
				Intent intent = null;
				if (NameOfRoute.equals("天河城线"))
					intent = new Intent(MainActivity.this, FirstSimpleActivity.class);
				else if (NameOfRoute.equals("天河公园线"))
					intent = new Intent(MainActivity.this, SecondSimpleActivity.class);
				else if (NameOfRoute.equals("大学城线"))
					intent = new Intent(MainActivity.this, ScrollActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.enter_righttoleft,0);
				
			}
		});

		// overridePendingTransition(R.anim.base_slide_right_in,
		// R.anim.base_slide_remain);
		//overridePendingTransition(android.R.anim.slide_in_left,
				//android.R.anim.slide_out_right);
	}

	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// overridePendingTransition(0, R.anim.base_slide_right_out);
		overridePendingTransition(0, android.R.anim.slide_out_right);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
