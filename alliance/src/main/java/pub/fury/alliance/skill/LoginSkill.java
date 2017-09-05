package pub.fury.alliance.skill;

import java.util.HashMap;
import java.util.concurrent.Callable;

import pub.fury.alliance.member.ILoginFunc;
import pub.fury.alliance.member.MemberManager;
import pub.fury.alliance.utils.Callables;
import pub.fury.alliance.error.FuncNotFoundException;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class LoginSkill extends Skill<ILoginFunc> {
	
	public LoginSkill(String type) {
		super(type);
	}
	
	@Override
	protected ILoginFunc initFunc(String type) {
		return MemberManager.get().getLoginFuncByType(type);
	}
	
	@Override
	public Callable<HashMap<String, String>> action(HashMap<String, String> extras) {
		ILoginFunc func = getFunc();
		if (null == func) {
			return Callables.error(new FuncNotFoundException(getType()));
		}
		return func.login(getType(), extras);
	}
}
