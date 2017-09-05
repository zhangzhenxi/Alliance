package pub.fury.alliance.skill;

import java.util.HashMap;
import java.util.concurrent.Callable;

import pub.fury.alliance.member.IMemberFunc;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public abstract class Skill<Func extends IMemberFunc> {
	
	private final String mType;
	private final Func mFunc;
	
	Skill(String type) {
		mType = type;
		mFunc = initFunc(mType);
	}
	
	protected abstract Func initFunc(String type);
	
	public String getType() {
		return mType;
	}
	
	Func getFunc() {
		return mFunc;
	}
	
	public abstract Callable<HashMap<String, String>> action(HashMap<String, String> in);
}
