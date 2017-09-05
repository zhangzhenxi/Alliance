package pub.fury.alliance.error;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public class FuncNotFoundException extends Exception implements AllianceException {
	
	private final String mType;
	
	public FuncNotFoundException(String type) {
		super("IFunc not found by type " + type);
		mType = type;
	}
}
