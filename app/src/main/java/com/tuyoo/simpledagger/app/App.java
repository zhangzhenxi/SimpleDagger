package com.tuyoo.simpledagger.app;

import android.app.Application;
import android.content.Context;

import com.tuyoo.simpledagger.ui.ActivityComponent;

/**
 * Created by zhenxi on 16/6/7.
 */
public class App extends Application {

	private AppComponent component;
	private ActivityComponent activityComponent;

	public static App get(Context context) {
		return (App) context.getApplicationContext();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		daggerInjectionInit();
	}

	private void daggerInjectionInit() {
		component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
		activityComponent = component.act();
	}

	public AppComponent getComponent() {
		return component;
	}

	public ActivityComponent getActivityComponent() {
		return activityComponent;
	}

}
