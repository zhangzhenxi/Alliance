package pub.fury.alliance.internal;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Map;

import pub.fury.alliance.injector.AppInjector;
import pub.fury.alliance.member.IMemberLifeCycle;
import pub.fury.alliance.member.MemberManager;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public class AppInjectorImpl implements AppInjector {
	
	@Override
	public void onAppCreate(Application application) {
		for (Map.Entry<String, IMemberLifeCycle> entry: MemberManager.get().getMemberLifeCycleMap().entrySet()) {
			IMemberLifeCycle lifeCycle = entry.getValue();
			Log.i("INJECTION", "onAppCreate:[" + entry.getKey() + "]");
			lifeCycle.onAppCreate(application);
		}
	}
	
	@Override
	public void attachBaseContext(Application application, Context base) {
		MemberManager.get().memberInit(application, base);
		for (Map.Entry<String, IMemberLifeCycle> entry : MemberManager.get().getMemberLifeCycleMap().entrySet()) {
			IMemberLifeCycle lifeCycle = entry.getValue();
			Log.i("INJECTION", "attachBaseContext:[" + entry.getKey() + "]");
			lifeCycle.attachBaseContext(application, base);
		}
	}
	
	@Override
	public void onConfigurationChanged(Application application, Configuration newConfig) {
		for (Map.Entry<String, IMemberLifeCycle> entry : MemberManager.get().getMemberLifeCycleMap().entrySet()) {
			IMemberLifeCycle lifeCycle = entry.getValue();
			Log.i("INJECTION", "onConfigurationChanged:[" + entry.getKey() + "]");
			lifeCycle.onConfigurationChanged(application, newConfig);
		}
	}
}
