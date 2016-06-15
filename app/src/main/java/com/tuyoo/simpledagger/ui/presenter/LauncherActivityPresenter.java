package com.tuyoo.simpledagger.ui.presenter;

import android.util.Log;
import android.widget.Toast;

import com.tuyoo.simpledagger.manager.LoginManager;
import com.tuyoo.simpledagger.ui.act.LauncherActivity;

import org.json.JSONObject;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by zhenxi on 16/6/7.
 */
public class LauncherActivityPresenter {
	
	private LauncherActivity launcherActivity;
	private LoginManager loginManager;
	private Subscription subscribe;

	public LauncherActivityPresenter(LauncherActivity launcherActivity, LoginManager loginManager) {
		this.launcherActivity = launcherActivity;
		this.loginManager = loginManager;
	}

	public void login() {
		subscribe = loginManager.login().subscribe(new Subscriber<JSONObject>() {
			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
				Log.e("login error", e.toString());
				Toast.makeText(launcherActivity, e.toString(), Toast.LENGTH_SHORT).show();
				launcherActivity.setText(e.toString());
			}

			@Override
			public void onNext(JSONObject jsonObject) {
			}
		});
	}

	public void destroy(){
		if(null != subscribe && !subscribe.isUnsubscribed()){
			subscribe.unsubscribe();
		}
	}
}
