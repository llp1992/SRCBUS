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

public class SecondComplexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondcomplex_activity);

		// 按钮
		Button button = (Button) findViewById(R.id.button2ofsecond);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondComplexActivity.this,
						SecondSimpleActivity.class);
				startActivity(intent);
			}
		});

		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.secondcomplex);
		mSildingFinishLayout
				.setOnSildingFinishListener(new OnSildingFinishListener() {

					@Override
					public void onSildingFinish() {
						// SecondComplexActivity.this.finish();
						Intent intent = new Intent(SecondComplexActivity.this,
								MainActivity.class);
						startActivity(intent);
					}
				});

		// touchView要设置到LinearLayout上
		LinearLayout linearlayout = (LinearLayout) findViewById(R.id.linearlayout22);
		mSildingFinishLayout.setTouchView(linearlayout);
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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
