package com.tuyoo.simpledagger.ui.component;

import com.tuyoo.simpledagger.ui.ActivityScope;
import com.tuyoo.simpledagger.ui.act.LauncherActivity;
import com.tuyoo.simpledagger.ui.module.LauncherActivityModule;

import dagger.Subcomponent;

/**
 * Created by zhenxi on 16/6/7.
 */
@ActivityScope
@Subcomponent(
	modules = {
		LauncherActivityModule.class
	}
)
public interface LauncherActivityComponent {

	void inject(LauncherActivity activity);
}
