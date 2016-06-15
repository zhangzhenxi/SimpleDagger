package com.tuyoo.simpledagger.manager;

import com.tuyoo.simpledagger.data.LoginApi;

import org.json.JSONObject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhenxi on 16/6/7.
 */
public class LoginManager {

	private LoginApi loginApi;

	public LoginManager(LoginApi loginApi) {
		this.loginApi = loginApi;
	}

	public Observable<JSONObject> login(){
		return loginApi.login("").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
	}
}
