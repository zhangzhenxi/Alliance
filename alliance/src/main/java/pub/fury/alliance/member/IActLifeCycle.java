package pub.fury.alliance.member;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/5
 */
public interface IActLifeCycle extends IMemberFunc {
	
	// IMemberLifeCycle#onActCreate
//	void onActCreate(Activity activity, @Nullable Bundle state);
	
	void onStart(Activity activity);
	
	void onResume(Activity activity);
	
	void onRestart(Activity activity);
	
	void onNewIntent(Activity activity, Intent intent);
	
	void onPause(Activity activity);
	
	void onStop(Activity activity);
	
	void onDestroy(Activity activity);
}
