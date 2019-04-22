package com.ar4i.cats.data.network.interceptors;

import com.ar4i.cats.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();

        Request request = original.newBuilder()
                .header(BuildConfig.TOKEN_HEADER_KEY, BuildConfig.TOKEN_HEADER_VALUE)
                .build();

        return chain.proceed(request);
    }
}
