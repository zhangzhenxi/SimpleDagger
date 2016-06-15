package com.tuyoo.simpledagger.ui.module;

import com.tuyoo.simpledagger.manager.LoginManager;
import com.tuyoo.simpledagger.manager.ManagerModule;
import com.tuyoo.simpledagger.ui.ActivityScope;
import com.tuyoo.simpledagger.ui.act.LauncherActivity;
import com.tuyoo.simpledagger.ui.presenter.LauncherActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhenxi on 16/6/7.
 */
@Module
public class LauncherActivityModule {

	private LauncherActivity launcherActivity;

	public LauncherActivityModule(LauncherActivity launcherActivity) {
		this.launcherActivity = launcherActivity;
	}

	@Provides
	@ActivityScope
	LauncherActivityPresenter provideLauncherActivityPresenter(LoginManager loginManager) {
		return new LauncherActivityPresenter(launcherActivity, loginManager);
	}

	@Provides
	@ActivityScope
	LauncherActivity provideLauncherActivity() {
		return launcherActivity;
	}

}
