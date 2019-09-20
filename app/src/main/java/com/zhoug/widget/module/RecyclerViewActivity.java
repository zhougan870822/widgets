package com.zhoug.widget.module;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhoug.android.widget.adapters.recycler.BaseRecyclerAdapter;
import com.zhoug.android.widget.adapters.recycler.BaseViewHolder;
import com.zhoug.android.widget.dividers.DividerItem;
import com.zhoug.widget.module.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends BaseActivity {
    private RecyclerView recyclerView;

    private List<String> data = new ArrayList<>();
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItem dividerItem = new DividerItem(this, OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(dividerItem);

        initAdatper();

        recyclerView.setAdapter(mAdapter);
    }

    private void initAdatper() {
        for(int i=0;i<20;i++){
            data.add("item"+i);
        }
        mAdapter = new Adapter();
        mAdapter.setData(data);
        mAdapter.setLoadMoreEnable(true);
        mAdapter.setOnItemChildClickListener(new BaseRecyclerAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseRecyclerAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.textView:
                        toast(mAdapter.getItemData(position));
                        break;
                }
            }
        });
        mAdapter.setOnLoadMoreListener(new BaseRecyclerAdapter.OnLoadMoreListener() {
            @Override
            public void requestLoadMore() {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               Random random=new Random();
                               int in = random.nextInt(3);
                               if(in==0){
                                   mAdapter.loadMoreFail();
                               }else if(in==2){
                                   mAdapter.loadMoreEnd();
                               }else{
                                   List<String> cacheData=new ArrayList<>();
                                   for(int i=data.size();i<data.size()+5;i++){
                                       cacheData.add("item"+i);
                                   }
                                   mAdapter.getData().addAll(cacheData);
                                   mAdapter.loadMoreComplete();
                               }
                           }
                       });
                   }
               }).start();



            }
        });
    }

    private class Adapter extends BaseRecyclerAdapter<String> {

        @Override
        public int getLayoutId(int viewType) {
            return R.layout.list_item;
        }

        @Override
        public void onBindData(BaseViewHolder holder, String itemData, int position, int viewType) {
            holder.setText(R.id.textView, itemData)
                    .setImageResource(R.id.imageView, position % 2 == 0 ? R.drawable.icon_1 : R.drawable.icon_2);
            holder.addOnClickListener(R.id.textView);


        }
    }


}
