package pub.fury.alliance.skill;

import java.util.HashMap;
import java.util.concurrent.Callable;

import pub.fury.alliance.invoker.InvokerResult;
import pub.fury.alliance.member.IPayFunc;
import pub.fury.alliance.member.MemberManager;
import pub.fury.alliance.utils.Callables;
import pub.fury.alliance.error.FuncNotFoundException;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class PaySkill extends Skill<IPayFunc> {
	
	public PaySkill(String type) {
		super(type);
	}
	
	@Override
	protected IPayFunc initFunc(String type) {
		return MemberManager.get().getPayFuncByType(type);
	}
	
	@Override
	public Callable<HashMap<String, String>> action(HashMap<String, String> in) {
		IPayFunc func = getFunc();
		if (null == func) {
			return Callables.error(new FuncNotFoundException(getType()));
		}
		Callable<HashMap<String, String>> payExtrasCallable = func.getPayExtras(in);
		InvokerResult<HashMap<String, String>> invokerResult = Callables.execSync(payExtrasCallable);
		if (null != invokerResult.getError()) {
			return Callables.error(invokerResult.getError());
		} else {
			return func.pay(getType(), invokerResult.getResult());
		}
	}
}