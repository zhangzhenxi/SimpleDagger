package com.tuyoo.simpledagger.app;

import com.tuyoo.simpledagger.manager.LoginManager;
import com.tuyoo.simpledagger.manager.ManagerModule;
import com.tuyoo.simpledagger.ui.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhenxi on 16/6/7.
 */
@Singleton
@Component(
	modules = {
		AppModule.class,
		ManagerModule.class
	}
)
public interface AppComponent {

	App app();

	ActivityComponent act();

	LoginManager loginManager();

}
