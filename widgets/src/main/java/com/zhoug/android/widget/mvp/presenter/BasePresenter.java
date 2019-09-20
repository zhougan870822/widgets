package com.zhoug.android.widget.mvp.presenter;


import com.zhoug.android.widget.mvp.view.IView;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView> implements IPresenter<V>{
    private Reference<V> mViewRef;

    public BasePresenter(V v){
        mViewRef=new WeakReference<>(v);
    }



    @Override
    public void detachView() {
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef=null;
        }
    }

    @Override
    public V getView() {
        if(mViewRef!=null){
            return  mViewRef.get();
        }

        return null;
    }

    @Override
    public boolean isAttach() {
        return mViewRef!=null && mViewRef.get()!=null;

    }


}
