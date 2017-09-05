package pub.fury.alliance.error;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class ActionCanceledException extends Exception implements AllianceException {
	
	public ActionCanceledException() {
		super("callable has been canceled");
	}
}
