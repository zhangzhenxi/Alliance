package pub.fury.alliance.invoker;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import pub.fury.alliance.skill.Skill;
import pub.fury.alliance.utils.Callables;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class SkillInvoker {
	
	private final Skill<?> mSkill;
	
	public SkillInvoker(Skill<?> skill) {
		mSkill = skill;
	}
	
	public InvokerResult<HashMap<String, String>> call(HashMap<String, String> in, ExecutorService executor) {
		Callable<HashMap<String, String>> action = mSkill.action(in);
		return Callables.exec(action, executor);
	}
}
