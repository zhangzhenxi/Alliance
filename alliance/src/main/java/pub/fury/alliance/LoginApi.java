package pub.fury.alliance;

import java.util.HashMap;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface LoginApi {
	
	void loginByType(String type, HashMap<String, String> extras, Callback<HashMap<String, String>> callback);
	
	void loginByWechat(String appId, String appKey, Callback<HashMap<String, String>> callback);
}
