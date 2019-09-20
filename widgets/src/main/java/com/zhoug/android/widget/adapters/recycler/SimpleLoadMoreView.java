package com.zhoug.android.widget.adapters.recycler;


import com.zhoug.android.widget.R;

/**
 * 默认的加载更多视图
 */
public class SimpleLoadMoreView extends LoadMoreView{

    @Override
    public int getLayoutId() {
        return R.layout.widgets_load_more_view;
    }

    @Override
    protected int getLoadingDefaultId() {
        return R.id.load_more_default;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_error;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_end;
    }

}
