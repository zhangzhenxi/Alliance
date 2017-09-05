package pub.fury.alliance.invoker;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class InvokerResult<T> {
	
	private AtomicReference<T> resultRef = null;
	private AtomicReference<Exception> errorRef = null;
	
	public InvokerResult() {
		resultRef = new AtomicReference<>();
		errorRef = new AtomicReference<>();
	}
	
	public void setError(Exception e) {
		errorRef.set(e);
	}
	
	public void setResult(T result) {
		resultRef.set(result);
	}
	
	public T getResult() {
		return resultRef.get();
	}
	
	public Exception getError() {
		return errorRef.get();
	}
}
