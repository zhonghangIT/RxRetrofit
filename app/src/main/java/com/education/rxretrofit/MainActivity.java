package com.education.rxretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.education.rxretrofit.bean.DouyuBean;
import com.education.rxretrofit.config.UrlConfig;
import com.education.rxretrofit.http.HttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import rx.Completable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    Subscription subscription;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> params = new HashMap<>();
        params.put(UrlConfig.Params.LIMIT, "20");
        params.put(UrlConfig.Params.OFFSET, "0");
        params.put(UrlConfig.Params.TIME, UrlConfig.DefaultValue.TIME);
        compositeSubscription.add(subscription);
        compositeSubscription.unsubscribe();
        subscription = HttpUtils.newInstance().getFace(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DouyuBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DouyuBean douyuBean) {

                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}
