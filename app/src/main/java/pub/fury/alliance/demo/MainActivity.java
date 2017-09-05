package pub.fury.alliance.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

import pub.fury.alliance.Alliance;
import pub.fury.alliance.AllianceActivity;
import pub.fury.alliance.Callback;

public class MainActivity extends AllianceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void doNormalLogin(View view) {
		HashMap<String, String> extras = new HashMap<>();
		extras.put("extra1", "value1");
		extras.put("extra2", "value2");
		extras.put("extra3", "value3");
		Alliance.INSTANCE.getLoginApi().loginByType("typeName", extras, new Callback<HashMap<String, String>>() {
			@Override
			public void call(int code, HashMap<String, String> result, String msg) {
				Log.i("MainActivity", "doNormalLogin " + msg);
			}
		});
	}
	
	public void doLogin(View view) {
		Alliance.INSTANCE.getLoginApi().loginByWechat("stubAppId", "stubAppKey", new Callback<HashMap<String, String>>() {
			@Override
			public void call(int code, HashMap<String, String> result, String msg) {
				switch (code) {
					case CODE_OK:
						Log.i("MainActivity", "doLogin ok.");
						break;
					case CODE_CANCEL:
					case CODE_INTERRUPTED:
					case CODE_FAILED:
						Log.e("MainActivity", "doLogin:" + msg);
						break;
				}
			}
		});
	}
	
	public void doPayment(View view) {
		Alliance.INSTANCE.getPayApi().payByAli("stubReq", new Callback<HashMap<String, String>>() {
			@Override
			public void call(int code, HashMap<String, String> result, String msg) {
				switch (code) {
					case CODE_OK:
						Log.i("MainActivity", "doPayment ok.");
						break;
					case CODE_CANCEL:
					case CODE_INTERRUPTED:
					case CODE_FAILED:
						Log.e("MainActivity", "doPayment:" + msg);
						break;
				}
			}
		});
	}
}
