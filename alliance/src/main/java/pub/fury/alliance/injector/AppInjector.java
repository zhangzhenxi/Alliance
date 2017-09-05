package pub.fury.alliance.injector;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface AppInjector {
	
	void onAppCreate(Application application);
	
	void attachBaseContext(Application application, Context base);
	
	void onConfigurationChanged(Application application, Configuration newConfig);
}
