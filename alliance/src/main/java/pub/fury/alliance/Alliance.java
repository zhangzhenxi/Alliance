package pub.fury.alliance;

import pub.fury.alliance.injector.ActInjector;
import pub.fury.alliance.injector.AppInjector;
import pub.fury.alliance.internal.AllianceImpl;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface Alliance {
	
	Alliance INSTANCE = new AllianceImpl();
	
	ActInjector getActInjector();
	
	AppInjector getAppInjector();
	
	LoginApi getLoginApi();
	
	PayApi getPayApi();
}
