package pub.fury.alliance.injector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public interface ActInjector {
	
	void onCreate(Activity activity, @Nullable Bundle state);
	
	void onStart(Activity activity);
	
	void onResume(Activity activity);
	
	void onRestart(Activity activity);
	
	void onNewIntent(Activity activity, Intent intent);
	
	void onPause(Activity activity);
	
	void onStop(Activity activity);
	
	void onDestroy(Activity activity);
}
