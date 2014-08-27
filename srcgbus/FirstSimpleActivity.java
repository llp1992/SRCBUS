package com.example.srcgbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.example.view.SildingFinishLayout;
import com.example.view.SildingFinishLayout.OnSildingFinishListener;

public class FirstSimpleActivity extends Activity {

	final int LIST_DIALOG1 = 0x111;
	// private static Boolean isExit = false;
	private String tag = "CodeView";
	int i = 0;
	int flag = 0;
	Vibrator vibrator;
	// 声明一个Handler对象
	// private static Handler handler = new Handler();
	TextToSpeech tts;
	// 定义get_data为从那个选择路线的Activity传过来的值，1表示line1，2表示line2,3表示line3
	int get_data = 2;
	String line1[] = new String[] { "天河城东门", "岗顶麦当劳", "暨大北门", " 岑村", " 凌塘" };
	String line2[] = new String[] { "江南花园", "中大南门", "鹭江地铁D出口", "客村建行", };
	String line3[] = new String[] { "嘉逸皇冠", "奥体中心", " 岭南学院" };
	String str = "岗顶";
	// final Builder builder1 = new AlertDialog.Builder(this);
	Timer tExit = new Timer();
	Timer timer1 = new Timer();
	Timer timer2 = new Timer();
	Timer timer3 = new Timer();
	MyTimerTask task;
	String contextService = Context.LOCATION_SERVICE;

	// 调用闹钟进行定站提醒
	class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			Log.v(tag, "test1");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstsimple_activity);
		
		if(flag == 1)
		{
			Toast.makeText(FirstSimpleActivity.this, "kill", Toast.LENGTH_LONG).show();
			if(timer1!=null)
			{
				timer1.cancel();
				timer1 = null;
			}
			else if(timer2!=null)
			{
				timer2.cancel();
				timer2 = null;
			}
			else if(timer3!=null)
			{
				timer3.cancel();
				timer3 = null;
			}
				
				
				
		}
		vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
		Button bt0 = (Button) findViewById(R.id.alert);

		bt0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG1);

			}
		});

		tts = new TextToSpeech(this, new OnInitListener() {
			@Override
			public void onInit(int status) {
				// 如果装载TTS引擎成功
				if (status == TextToSpeech.SUCCESS) {
					// 设置使用美式英语朗读(虽然设置里有中文选项Locale.Chinese,但并不支持中文)
					int result = tts.setLanguage(Locale.US);
					// 如果不支持设置的语言
					if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
							&& result != TextToSpeech.LANG_AVAILABLE) {
						Toast.makeText(FirstSimpleActivity.this,
								"TTS暂时不支持这种语言朗读", 50000).show();
					}
				}
			}
		});

		// ------------------------------------------------------------------------------------

		// 按键
		Button button = (Button) findViewById(R.id.button1offirst);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// FirstSimpleActivity.this.finish();
				Intent intent = new Intent(FirstSimpleActivity.this,
						FirstComplexActivity.class);
				// FirstSimpleActivity.this.finish();
				startActivity(intent);
				overridePendingTransition(R.anim.enter_righttoleft, 0);
			}
		});

		// 设置侧滑
		SildingFinishLayout mSildingFinishLayout = (SildingFinishLayout) findViewById(R.id.firstsimple);
		mSildingFinishLayout
				.setOnSildingFinishListener(new OnSildingFinishListener() {

					@Override
					public void onSildingFinish() {
						// FirstSimpleActivity.this.finish();
						Intent intent = new Intent(FirstSimpleActivity.this,
								MainActivity.class);

						startActivity(intent);
						// overridePendingTransition(0,
						// android.R.anim.slide_out_right);
						// 使用自定义退出动画
						overridePendingTransition(0, R.anim.out_lefttoright);
						FirstSimpleActivity.this.finish();
					}
				});

		// 设置侧滑监听事件，将touchview设置在线性布局上
		// LinearLayout linearlayout = (LinearLayout)
		// findViewById(R.id.linearlayout);
		SildingFinishLayout sildingfinishlayout = (SildingFinishLayout) findViewById(R.id.firstsimple);
		mSildingFinishLayout.setTouchView(sildingfinishlayout);
	}

	
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.v("test1", "Restart");
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("test1", "Start");
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("test1", "Pause");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("test1", "Resume");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("test1", "Stop");
	}

	// 龙坡
	@Override
	public void onDestroy() {
		// 关闭TextToSpeech对象
		super.onDestroy();
		Log.v("test1", "Destory");
		if (tts != null)
			tts.shutdown();
		if (timer1 != null) {
			timer1.cancel();
			timer1 = null;
		} else if (timer2 != null) {
			timer2.cancel();
			timer2 = null;
		} else if (timer3 != null) {
			timer3.cancel();
			timer3 = null;
		}
	}

	// 定站提醒功能的实现
	public Dialog onCreateDialog(int id, Bundle state) {
		switch (id) {
		case LIST_DIALOG1:

			Builder b = new AlertDialog.Builder(this);
			final Builder builder = new AlertDialog.Builder(this);
			// 设置对话框的图标
			b.setIcon(R.drawable.xiaoba1);
			// 设置对话框的标题
			b.setTitle("定站提醒");
			// 创建一个List对象，List对象的元素是Map
			List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
			if (get_data == 1) {
				for (int i = 0; i < line1.length; i++) {
					Map listItem = new HashMap();
					// listItem.put("header", imageIds[i]);
					listItem.put("personName", line1[i]);
					listItems.add(listItem);
				}
			} else if (get_data == 2) {
				for (int i = 0; i < line2.length; i++) {
					Map listItem = new HashMap();
					// listItem.put("header", imageIds[i]);
					listItem.put("personName", line2[i]);
					listItems.add(listItem);
				}
			} else if (get_data == 3) {
				for (int i = 0; i < line3.length; i++) {
					Map listItem = new HashMap();
					// listItem.put("header", imageIds[i]);
					listItem.put("personName", line3[i]);
					listItems.add(listItem);
				}
			}

			// 创建一个SimpleAdapter
			SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
					R.layout.row, new String[] { "personName", "header" },
					new int[] { R.id.name, R.id.header });
			b.setAdapter(simpleAdapter
			// 为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								final int which) {

							if (get_data == 1) {
								Toast.makeText(FirstSimpleActivity.this,
										"设置" + line1[which] + "成功~~",
										Toast.LENGTH_LONG).show();
								str = line1[which].substring(0,
										line1[which].length());
								timer1.schedule(new TimerTask() {
									@Override
									public void run() {
										Log.v("test", "test");
									}
								}, 0, 1000);
							} else if (get_data == 2) {
								Toast.makeText(FirstSimpleActivity.this,
										"设置" + line2[which] + "成功~~",
										Toast.LENGTH_LONG).show();
								str = line2[which].substring(0,
										line2[which].length());
								// Log.v(tag, "选中");

								timer2.schedule(new TimerTask() {
									@Override
									public void run() {

										i = i + 1;
										Log.v("test", "tts");
										if (i == 8) {

											// 要求从Alert.Activity返回数据
											Intent intent = new Intent(
													FirstSimpleActivity.this,
													Alert.class);
//											startActivityForResult(intent, 0);
											startActivity(intent);

										}

									}
								}, 0, 1000);

							} else if (get_data == 3) {
								Toast.makeText(FirstSimpleActivity.this,
										"设置" + line3[which] + "成功~~",
										Toast.LENGTH_LONG).show();
								str = line3[which].substring(0,
										line3[which].length());
								timer3.schedule(new TimerTask() {
									@Override
									public void run() {
										Log.v("test", "test");
									}
								}, 0, 1000);
							}

						}
					});
			return b.create();
		}

		return null;
	}

	// ---------------------------------------------------------------------oncreate

	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Log.v("test1", "back");
		// overridePendingTransition(0, R.anim.base_slide_right_out);
		Intent intent = new Intent(FirstSimpleActivity.this, MainActivity.class);
		FirstSimpleActivity.this.finish();
		startActivity(intent);
		// overridePendingTransition(0, android.R.anim.slide_out_right);
		// 使用自定义退出动画
		overridePendingTransition(0, R.anim.out_lefttoright);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, intent);

		if (requestCode == 0 && resultCode == 0) {
			Bundle data = intent.getExtras();
			flag = data.getInt("timer");
			if (flag == 1) {
				Toast.makeText(FirstSimpleActivity.this, "kill",
						Toast.LENGTH_LONG).show();
				if (timer1 != null) {
					timer1.cancel();
					timer1 = null;
				} else if (timer2 != null) {
					timer2.cancel();
					timer2 = null;
				} else if (timer3 != null) {
					timer3.cancel();
					timer3 = null;
				}

			}
		}

	}

}