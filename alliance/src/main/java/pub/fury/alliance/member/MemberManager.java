package pub.fury.alliance.member;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

import pub.fury.alliance.R;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class MemberManager {
	
	private final static class Creator {
		private static MemberManager INSTANCE = new MemberManager();
	}
	
	private final HashMap<String, ILoginFunc> loginFuncMap;
	private final HashMap<String, IPayFunc> payFuncMap;
	private final HashMap<String, IMemberLifeCycle> memberLifeCycleMap;
	private final HashMap<String, IActLifeCycle> actLifeCycleMap;
	private final HashMap<String, String> memberMap;
	
	private MemberManager() {
		loginFuncMap = new HashMap<>();
		payFuncMap = new HashMap<>();
		memberLifeCycleMap = new HashMap<>();
		actLifeCycleMap = new HashMap<>();
		memberMap = new HashMap<>();
		MemberMap.initMemberClassPathMap(memberMap);
	}
	
	public static MemberManager get() {
		return Creator.INSTANCE;
	}
	
	public void memberInit(Application application, Context base) {
		if (null == application) {
			throw new NullPointerException("application == null while init Alliance");
		}
		String members = application.getString(R.string.members);
		if (TextUtils.isEmpty(members)) {
			throw new IllegalArgumentException("members is empty, check config.json in root dir of root project");
		}
		String[] array = members.split(",");
		String prefix = "pub.fury.alliance.member.impl.";
		for (String memberName : array) {
			String fullClassName = prefix + memberMap.get(memberName);
			try {
				Class<?> memberClass = Class.forName(fullClassName);
				memberClass.getInterfaces();
				memberClass.getGenericInterfaces();
				Object memberObj = memberClass.newInstance();
				if (IMemberLifeCycle.class.isInstance(memberObj)) {
					memberLifeCycleMap.put(memberName, (IMemberLifeCycle) memberObj);
				} else {
					Log.w("memberInit", "Member initialization abort : Member should implements pub.fury.alliance.member.IMemberLifeCycle");
				}
			} catch (ClassNotFoundException e) {
				// eat exception
			} catch (IllegalAccessException e) {
				// eat exception
			} catch (InstantiationException e) {
				// eat exception
			}
		}
	}
	
	public HashMap<String, IMemberLifeCycle> getMemberLifeCycleMap() {
		return memberLifeCycleMap;
	}
	
	public HashMap<String, IActLifeCycle> getActLifeCycleMap() {
		return actLifeCycleMap;
	}
	
	public void regist(String identity, IActLifeCycle lifeCycle) {
		Log.i("REGISTRATION", "IActLifeCycle:[" + identity + "]");
		actLifeCycleMap.put(identity, lifeCycle);
	}
	
	public void regist(String type, IPayFunc payFunc) {
		Log.i("REGISTRATION", "IPayFunc:[" + type + "]");
		payFuncMap.put(type, payFunc);
	}
	
	public void regist(String type, ILoginFunc loginFunc) {
		Log.i("REGISTRATION", "ILoginFunc:[" + type + "]");
		loginFuncMap.put(type, loginFunc);
	}
	
	public ILoginFunc getLoginFuncByType(String type) {
		return loginFuncMap.get(type);
	}
	
	public IPayFunc getPayFuncByType(String type) {
		return payFuncMap.get(type);
	}
}
