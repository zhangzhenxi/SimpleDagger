package com.tuyoo.simpledagger.ui;

import com.tuyoo.simpledagger.app.UserScope;
import com.tuyoo.simpledagger.ui.component.LauncherActivityComponent;
import com.tuyoo.simpledagger.ui.module.LauncherActivityModule;

import dagger.Subcomponent;

/**
 * Created by zhenxi on 16/6/7.
 */
@UserScope
@Subcomponent
public interface ActivityComponent {

	LauncherActivityComponent plus(LauncherActivityModule activityModule);
}
