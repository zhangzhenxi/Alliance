package pub.fury.alliance.utils;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public abstract class Singleton<T> {
	
	private volatile T instance = null;
	
	protected abstract T create();
	
	public final T get() {
		if (instance == null) {
			synchronized (this) {
				if (instance == null) {
					instance = create();
				}
			}
		}
		return instance;
	}
}
