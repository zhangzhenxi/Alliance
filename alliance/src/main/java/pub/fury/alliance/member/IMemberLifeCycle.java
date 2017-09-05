package pub.fury.alliance.member;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface IMemberLifeCycle extends IMemberFunc {
	
	void attachBaseContext(Application application, Context base);
	
	void onAppCreate(Application application);
	
	void onConfigurationChanged(Application application, Configuration newConfig);
	
	void onActCreate(Activity activity, @Nullable Bundle state);
}
