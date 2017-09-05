package pub.fury.alliance;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class AllianceApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		Alliance.INSTANCE.getAppInjector().onAppCreate(this);
	}
	
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		Alliance.INSTANCE.getAppInjector().attachBaseContext(this, base);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Alliance.INSTANCE.getAppInjector().onConfigurationChanged(this, newConfig);
	}
}
