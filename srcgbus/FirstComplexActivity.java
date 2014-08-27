package com.example.srcgbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

//import com.example.helloworld.R;
import com.example.view.SildingFinishLayout;
import com.example.view.SildingFinishLayout.OnSildingFinishListener;

public class FirstComplexActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstcomplex_activity);

		Button button = (Button) findViewById(R.id.button2offirst);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FirstComplexActivity.this,
						FirstSimpleActivity.class);
				startActivity(intent);
				overridePendingTransition(0, android.R.anim.slide_out_right);
			}
		});

		// 设置侧滑
		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.firstcomplex);
		mSildingFinishLayout
				.setOnSildingFinishListener(new OnSildingFinishListener() {

					@Override
					public void onSildingFinish() {
						// FirstComplexActivity.this.finish();
						Intent intent = new Intent(FirstComplexActivity.this,
								MainActivity.class);
						startActivity(intent);
					}
				});
		// 设置侧滑监听事件，将touchview设置在线性布局上
		LinearLayout linearlayout = (LinearLayout) findViewById(R.id.linearlayout12);
		mSildingFinishLayout.setTouchView(linearlayout);
	}

	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		// overridePendingTransition(0, R.anim.base_slide_right_out);
		Intent intent = new Intent(FirstComplexActivity.this,
				MainActivity.class);
		startActivity(intent);
		overridePendingTransition(0, android.R.anim.slide_out_right);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
