package com.bassem.mvpsample.helper;

import retrofit2.Response;

/**
 * Created by staff on 2017.01.01.
 */

public interface ServiceCallResultListener {
    public void onResponse(String json);

    public void onError(Throwable throwable);
}
