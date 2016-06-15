package com.tuyoo.simpledagger.manager;

import com.tuyoo.simpledagger.data.LoginApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhenxi on 16/6/7.
 */
@Module
public class ManagerModule {

	public ManagerModule() {
	}

	@Provides
	@Singleton
//	@Singleton
	LoginManager provideLoginManager(LoginApi loginApi) {
		return new LoginManager(loginApi);
	}
}
