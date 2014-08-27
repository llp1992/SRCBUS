package com.example.srcgbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;

import com.example.srcgbus.R;
import com.example.view.SildingFinishLayout;
import com.example.view.SildingFinishLayout.OnSildingFinishListener;

public class ScrollActivity extends Activity {

	private TextView textview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrollview_activity);

		textview = (TextView) findViewById(R.id.textview);
		SildingFinishLayout scrollact = (SildingFinishLayout) findViewById(R.id.third);
		scrollact.setOnSildingFinishListener(new OnSildingFinishListener() {

			@Override
			public void onSildingFinish() {
				ScrollActivity.this.finish();
			}
		});

		// 设置touchView到TextView上面
		scrollact.setTouchView(textview);

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// overridePendingTransition(0, R.anim.base_slide_right_out);
		overridePendingTransition(0, android.R.anim.slide_out_right);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
