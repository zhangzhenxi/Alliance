package pub.fury.alliance.utils;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import pub.fury.alliance.Callback;
import pub.fury.alliance.error.ActionCanceledException;
import pub.fury.alliance.error.AllianceException;
import pub.fury.alliance.invoker.InvokerResult;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class Callables {
	
	public static <T> Callable<T> just(final T data) {
		return new Callable<T>() {
			@Override
			public T call() throws Exception {
				return data;
			}
		};
	}
	
	public static <T> Callable<T> error(final Exception e) {
		return new Callable<T>() {
			@Override
			public T call() throws Exception {
				throw e;
			}
		};
	}
	
	public static <T> void errorCallback(Callback<T> callback, Exception error) {
		if (null == callback) {
			error.printStackTrace();
			return;
		}
		if (error instanceof InterruptedException) {
			callback.call(Callback.CODE_INTERRUPTED, null, error.getMessage());
			return;
		}
		if (error instanceof ActionCanceledException) {
			callback.call(Callback.CODE_CANCEL, null, error.getMessage());
			return;
		}
		if (error instanceof ExecutionException) {
			Throwable cause = error.getCause();
			cause.printStackTrace();
			callback.call(Callback.CODE_FAILED, null, cause.getMessage());
			return;
		}
		if (!(error instanceof AllianceException)) {
			error.printStackTrace();
		} else {
			Log.i("Alliance", error.getMessage());
		}
		callback.call(Callback.CODE_FAILED, null, error.getMessage());
	}
	
	public static <T> InvokerResult<T> execSync(Callable<T> callable) {
		return exec(callable, null);
	}
	
	public static <T> InvokerResult<T> exec(Callable<T> callable, ExecutorService executor) {
		InvokerResult<T> result = new InvokerResult<>();
		if (null == executor) {
			return execSync(callable, result);
		} else {
			if (executor.isShutdown()) {
				result.setError(new RuntimeException("executor is shutdown"));
			} else {
				Future<T> submit = executor.submit(callable);
				try {
					if (submit.isCancelled()) {
						result.setError(new ActionCanceledException());
					} else {
						T t = submit.get();
						result.setResult(t);
					}
				} catch (InterruptedException e) {
					result.setError(e);
				} catch (ExecutionException e) {
					result.setError(e);
				}
			}
			return result;
		}
	}
	
	private static <T> InvokerResult<T> execSync(Callable<T> callable, InvokerResult<T> result) {
		try {
			T t = callable.call();
			result.setResult(t);
		} catch (Exception e) {
			result.setError(e);
		}
		return result;
	}
}
