package com.education.rxretrofit.http;

import com.education.rxretrofit.bean.DouyuBean;
import com.education.rxretrofit.config.UrlConfig;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by zhonghang on 2016/10/20.
 */

public interface RetrofitApi {

    @GET(UrlConfig.Path.ULR_HOT)
    Observable<DouyuBean> getDouyuData(@QueryMap() Map<String, String> params);
}
