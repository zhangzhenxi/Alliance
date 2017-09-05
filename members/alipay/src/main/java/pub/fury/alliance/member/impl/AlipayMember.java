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
 * @since 2017/9/4
 */
public class AlipayMember extends Member implements IPayFunc, ILoginFunc {
	
	private Alipay mAlipay;
	
	@Override
	public void attachBaseContext(Application application, Context base) {
		super.attachBaseContext(application, base);
		MemberManager.get().regist("alipay", (IPayFunc) this);
		MemberManager.get().regist("alipay", (ILoginFunc) this);
	}
	
	@Override
	public void onAppCreate(Application application) {
		super.onAppCreate(application);
		mAlipay = new Alipay();
	}
	
	@Override
	public void onActCreate(Activity activity, Bundle state) {
		super.onActCreate(activity, state);
		mAlipay.onActCreate(activity, state);
	}
	
	@Override
	public Callable<HashMap<String, String>> getPayExtras(HashMap<String, String> extras) {
		return Callables.just(extras);
	}
	
	@Override
	public Callable<HashMap<String, String>> pay(String type, HashMap<String, String> extras) {
		return mAlipay.pay(type, extras);
	}
	
	@Override
	public Callable<HashMap<String, String>> login(String type, HashMap<String, String> extras) {
		return mAlipay.login(type, extras);
	}
}
