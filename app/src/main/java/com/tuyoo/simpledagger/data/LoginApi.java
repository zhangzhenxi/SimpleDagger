package com.tuyoo.simpledagger.data;

import org.json.JSONObject;

import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by zhenxi on 16/6/7.
 */
public interface LoginApi {

	@POST
	Observable<JSONObject> login(@Url String url);
}
