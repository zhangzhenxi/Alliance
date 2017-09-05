package pub.fury.alliance.member;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface IPayFunc extends IMemberFunc {
	
	Callable<HashMap<String, String>> getPayExtras(HashMap<String, String> extras);
	
	Callable<HashMap<String, String>> pay(String type, HashMap<String, String> in);
}
