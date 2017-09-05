package pub.fury.alliance.member.impl;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public class Wechat {
	
	public void onAppCreate(Application application) {
		Log.i("Wechat", "onAppCreate " + application.getPackageName());
	}
	
	public void onActCreate(Activity activity) {
		Log.i("Wechat", "onCreate " + activity.getLocalClassName());
	}
	
	public Callable<HashMap<String, String>> pay(String type, final HashMap<String, String> extras) {
		return new Callable<HashMap<String, String>>() {
			@Override
			public HashMap<String, String> call() throws Exception {
				Log.i("Wechat", "pay");
				extras.put("Wechat", "pay");
				return extras;
			}
		};
	}
}
