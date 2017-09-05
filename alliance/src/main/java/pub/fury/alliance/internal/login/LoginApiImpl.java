package pub.fury.alliance.internal.login;

import java.util.HashMap;

import pub.fury.alliance.Callback;
import pub.fury.alliance.LoginApi;
import pub.fury.alliance.invoker.InvokerResult;
import pub.fury.alliance.invoker.SkillInvoker;
import pub.fury.alliance.skill.LoginSkill;
import pub.fury.alliance.utils.Callables;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class LoginApiImpl implements LoginApi {
	
	@Override
	public void loginByType(String type, HashMap<String, String> extras, Callback<HashMap<String, String>> callback) {
		LoginSkill loginSkill = new LoginSkill(type);
		SkillInvoker invoker = new SkillInvoker(loginSkill);
		InvokerResult<HashMap<String, String>> invokerResult = invoker.call(extras, null);
		Exception error = invokerResult.getError();
		
		if (null != error) {
			// deal with exception
			Callables.errorCallback(callback, error);
			return;
		}
		
		HashMap<String, String> result = invokerResult.getResult();
		if (null != result) {
			// deal with result data
			if (null != callback) {
				callback.call(Callback.CODE_OK, result, "OK");
			}
		}
	}
	
	@Override
	public void loginByWechat(String appId, String appKey, Callback<HashMap<String, String>> callback) {
		String type = "wechat";
		
		HashMap<String, String> in = new HashMap<>();
		in.put("wechat_app_id", appId);
		in.put("wechat_app_key", appKey);
		
		loginByType(type, in, callback);
	}
}
