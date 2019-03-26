package com.ar4i.cats.data.network.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private static final String KEY = "x-api-key";
    private static final String VALUE = "3068ca6b-8ce6-450f-9207-19660354ecd7";


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();

        Request request = original.newBuilder()
                .header(KEY, VALUE)
                .build();

        return chain.proceed(request);
    }
}
