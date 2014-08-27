package com.example.srcgbus;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class Alert extends Activity{
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert);
		
		final Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("班车定位");
		builder.setMessage("班车即将到站");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Alert.this,FirstSimpleActivity.class);
				startActivity(intent);
				
//				Intent intent =  getIntent();
//				Bundle data = new Bundle();
//				data.putLong("timer", 1);
//				intent.putExtra("timer", 1);
//				Alert.this.setResult(0, intent);
//				Alert.this.finishActivity(0);
				Alert.this.finish();
			}
		});
		builder.create().show();
		
	}
	

}
