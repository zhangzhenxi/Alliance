package pub.fury.alliance.member.impl;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public class Alipay {
	
	public Callable<HashMap<String, String>> pay(String type, final HashMap<String, String> extras) {
		return new Callable<HashMap<String, String>>() {
			@Override
			public HashMap<String, String> call() throws Exception {
				Log.i("alipay", "pay");
				extras.put("alipay", "pay");
				return extras;
			}
		};
	}
	
	public Callable<HashMap<String, String>> login(String type, final HashMap<String, String> extras) {
		return new Callable<HashMap<String, String>>() {
			@Override
			public HashMap<String, String> call() throws Exception {
				Log.i("alipay", "login");
				extras.put("alipay", "login");
				return extras;
			}
		};
	}
	
	public void onActCreate(Activity activity, Bundle state) {
		Log.i("alipay", "onCreate " + activity.getLocalClassName());
	}
}
