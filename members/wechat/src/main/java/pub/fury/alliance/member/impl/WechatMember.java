package pub.fury.alliance.member.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.HashMap;
import java.util.concurrent.Callable;

import pub.fury.alliance.member.ILoginFunc;
import pub.fury.alliance.member.IPayFunc;
import pub.fury.alliance.member.Member;
import pub.fury.alliance.member.MemberManager;
import pub.fury.alliance.utils.Callables;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public class WechatMember extends Member implements IPayFunc, ILoginFunc {
	
	private Wechat mWechat;
	
	@Override
	public void onActCreate(Activity activity, Bundle states) {
		super.onActCreate(activity, states);
		mWechat.onActCreate(activity);
	}
	
	@Override
	public void attachBaseContext(Application application, Context base) {
		super.attachBaseContext(application, base);
		MemberManager.get().regist("wechat", (IPayFunc) this);
		MemberManager.get().regist("wechat", (ILoginFunc) this);
	}
	
	@Override
	public void onAppCreate(Application application) {
		super.onAppCreate(application);
		mWechat = new Wechat();
		mWechat.onAppCreate(application);
	}
	
	@Override
	public Callable<HashMap<String, String>> getPayExtras(HashMap<String, String> extras) {
		extras.put("wechat_app_id", "balabalaid");
		extras.put("wechat_app_key", "balabalakey");
		return Callables.just(extras);
	}
	
	@Override
	public Callable<HashMap<String, String>> pay(String type, HashMap<String, String> extras) {
		return mWechat.pay(type, extras);
	}
	
	@Override
	public Callable<HashMap<String, String>> login(String type, HashMap<String, String> extras) {
		return mWechat.pay(type, extras);
	}
}
