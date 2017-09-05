package pub.fury.alliance.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import pub.fury.alliance.injector.ActInjector;
import pub.fury.alliance.member.IActLifeCycle;
import pub.fury.alliance.member.IMemberLifeCycle;
import pub.fury.alliance.member.MemberManager;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public class ActInjectorImpl implements ActInjector {
	
	@Override
	public void onCreate(Activity activity, @Nullable Bundle state) {
		for (IMemberLifeCycle next : MemberManager.get().getMemberLifeCycleMap().values()) {
			next.onActCreate(activity, state);
		}
	}
	
	@Override
	public void onStart(Activity activity) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onStart(activity);
		}
	}
	
	@Override
	public void onResume(Activity activity) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onResume(activity);
		}
	}
	
	@Override
	public void onRestart(Activity activity) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onRestart(activity);
		}
	}
	
	@Override
	public void onNewIntent(Activity activity, Intent intent) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onNewIntent(activity, intent);
		}
	}
	
	@Override
	public void onPause(Activity activity) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onPause(activity);
		}
	}
	
	@Override
	public void onStop(Activity activity) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onStop(activity);
		}
	}
	
	@Override
	public void onDestroy(Activity activity) {
		for (IActLifeCycle next : MemberManager.get().getActLifeCycleMap().values()) {
			next.onDestroy(activity);
		}
	}
}
