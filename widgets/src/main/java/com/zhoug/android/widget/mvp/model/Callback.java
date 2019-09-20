package com.zhoug.android.widget.mvp.model;

public interface Callback<T> {

    void onSuccess(T t);
    void onFail(String msg);
}
