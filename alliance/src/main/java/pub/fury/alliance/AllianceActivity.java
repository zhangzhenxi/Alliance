package pub.fury.alliance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/4
 */
public class AllianceActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Alliance.INSTANCE.getActInjector().onCreate(this, savedInstanceState);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Alliance.INSTANCE.getActInjector().onStart(this);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Alliance.INSTANCE.getActInjector().onResume(this);
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Alliance.INSTANCE.getActInjector().onRestart(this);
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Alliance.INSTANCE.getActInjector().onNewIntent(this, intent);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Alliance.INSTANCE.getActInjector().onPause(this);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Alliance.INSTANCE.getActInjector().onStop(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Alliance.INSTANCE.getActInjector().onDestroy(this);
	}
}
