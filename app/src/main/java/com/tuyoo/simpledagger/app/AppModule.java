package com.tuyoo.simpledagger.app;

import com.tuyoo.simpledagger.data.LoginApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhenxi on 16/6/7.
 */
@Module
public class AppModule {

	private static final String BASE_URL = "http://www.google.com";

	private App app;

	public AppModule(App app) {
		this.app = app;
	}

	@Provides
	@Singleton
	public App provideApp() {
		return app;
	}

	@Provides
	@Singleton
	public Retrofit provideRetrofit(OkHttpClient httpClient) {
		return new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
			.client(httpClient)
			.build();
	}

	@Provides
	@Singleton
	public OkHttpClient provideOkHttpClient() {
		return new OkHttpClient.Builder()
			.connectTimeout(20, TimeUnit.SECONDS)
			.addInterceptor(new Interceptor() {
				@Override
				public Response intercept(Chain chain) throws IOException {
					return chain.proceed(chain.request());
				}
			}).build();
	}

	@Provides
	@Singleton
	public LoginApi provideLoginApi(Retrofit retrofit) {
		return retrofit.create(LoginApi.class);
	}
}
