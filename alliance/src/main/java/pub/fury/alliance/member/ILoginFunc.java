package pub.fury.alliance.member;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface ILoginFunc extends IMemberFunc {
	
	Callable<HashMap<String, String>> login(String type, HashMap<String, String> extras);
}