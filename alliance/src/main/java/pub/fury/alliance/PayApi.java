package pub.fury.alliance;

import java.util.HashMap;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface PayApi {
	
	void pay(String type, HashMap<String, String> extras, Callback<HashMap<String, String>> callback);
	
	void payByAli(String alipayReq, Callback<HashMap<String, String>> callback);
}
