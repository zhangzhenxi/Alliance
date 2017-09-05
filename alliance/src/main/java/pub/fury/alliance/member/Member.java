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
public class Member implements IMemberLifeCycle {
	
	@Override
	public void attachBaseContext(Application application, Context base) {
	}
	
	@Override
	public void onAppCreate(Application application) {
	}
	
	@Override
	public void onConfigurationChanged(Application application, Configuration newConfig) {
	}
	
	@Override
	public void onActCreate(Activity activity, @Nullable Bundle state) {
	}
}
