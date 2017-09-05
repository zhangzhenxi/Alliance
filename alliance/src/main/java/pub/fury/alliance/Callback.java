package pub.fury.alliance;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface Callback<T> {
	
	int CODE_OK = 0;
	int CODE_FAILED = 1;
	int CODE_CANCEL = 2;
	int CODE_INTERRUPTED = 3;
	
	void call(int code, T result, String msg);
}
