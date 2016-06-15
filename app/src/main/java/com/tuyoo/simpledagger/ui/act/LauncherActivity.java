package com.tuyoo.simpledagger.ui.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tuyoo.simpledagger.R;
import com.tuyoo.simpledagger.app.App;
import com.tuyoo.simpledagger.ui.module.LauncherActivityModule;
import com.tuyoo.simpledagger.ui.presenter.LauncherActivityPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LauncherActivity extends AppCompatActivity {

	@Bind(R.id.text)
	TextView view;
	@Inject
	LauncherActivityPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		ButterKnife.bind(this);
		setComponent();
		presenter.login();
	}

	public void setText(String msg){
		view.setText(msg);
	}

	private void setComponent() {
		App.get(this).getActivityComponent().plus(new LauncherActivityModule(this)).inject(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.destroy();
	}
}
