package pub.fury.alliance.internal.pay;

import java.util.HashMap;

import pub.fury.alliance.Callback;
import pub.fury.alliance.PayApi;
import pub.fury.alliance.invoker.InvokerResult;
import pub.fury.alliance.invoker.SkillInvoker;
import pub.fury.alliance.skill.PaySkill;
import pub.fury.alliance.utils.Callables;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class PayApiImpl implements PayApi {
	
	@Override
	public void pay(String type, HashMap<String, String> extras, Callback<HashMap<String, String>> callback) {
		PaySkill paySkill = new PaySkill(type);
		SkillInvoker invoker = new SkillInvoker(paySkill);
		HashMap<String, String> in = new HashMap<>();
		in.put("alipay_req", "stubStr");
		InvokerResult<HashMap<String, String>> invokerResult = invoker.call(in, null);
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
	public void payByAli(String alipayReq, Callback<HashMap<String, String>> callback) {
		String type = "alipay";
		HashMap<String, String> in = new HashMap<>();
		in.put("alipay_req", alipayReq);
		pay(type, in, callback);
	}
}
