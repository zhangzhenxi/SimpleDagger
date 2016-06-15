package com.tuyoo.simpledagger.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by zhenxi on 16/6/7.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
