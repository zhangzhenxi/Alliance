package pub.fury.alliance.internal;

import pub.fury.alliance.Alliance;
import pub.fury.alliance.LoginApi;
import pub.fury.alliance.PayApi;
import pub.fury.alliance.injector.ActInjector;
import pub.fury.alliance.injector.AppInjector;
import pub.fury.alliance.internal.login.LoginApiImpl;
import pub.fury.alliance.internal.pay.PayApiImpl;
import pub.fury.alliance.utils.Singleton;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public final class AllianceImpl implements Alliance {
	private Singleton<ActInjector> mActInjector = new Singleton<ActInjector>() {
		@Override
		protected ActInjector create() {
			return new ActInjectorImpl();
		}
	};
	
	private Singleton<AppInjector> mAppInjector = new Singleton<AppInjector>() {
		@Override
		protected AppInjector create() {
			return new AppInjectorImpl();
		}
	};
	
	private Singleton<LoginApi> mLoginApi = new Singleton<LoginApi>() {
		@Override
		protected LoginApi create() {
			return new LoginApiImpl();
		}
	};
	
	private Singleton<PayApi> mPayApi = new Singleton<PayApi>() {
		@Override
		protected PayApi create() {
			return new PayApiImpl();
		}
	};
	
	@Override
	public ActInjector getActInjector() {
		return mActInjector.get();
	}
	
	@Override
	public AppInjector getAppInjector() {
		return mAppInjector.get();
	}
	
	@Override
	public LoginApi getLoginApi() {
		return mLoginApi.get();
	}
	
	@Override
	public PayApi getPayApi() {
		return mPayApi.get();
	}
}
