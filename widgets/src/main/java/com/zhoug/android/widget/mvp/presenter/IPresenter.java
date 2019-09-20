package com.zhoug.android.widget.mvp.presenter;

/**
 * 描述：mvp的控制中心接口,把model的数据绑定给View
 * Presenter通过调用 View与Model的实现接口，来操作 View与Model；
 * 同时Presenter也是以接口的形式出现在View中，这样Presenter与View就是通过接口相互依赖了
 * zhougan
 * 2019/3/21
 **/
public interface IPresenter<V> {

    /**
     * 解绑视图
     */
    void detachView();

    /**
     * 获取视图
     * @return
     */
    V getView();

    /**
     * 视图是否被绑定
     * 被回收了就返回false
     * @return
     */
    boolean isAttach();

    /**
     * 需要的初始化执行
     */
    void init();



}
