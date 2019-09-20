package com.zhoug.widget.module;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhoug.android.widget.adapters.SimpleListAdapter;
import com.zhoug.widget.module.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity implements ListView.OnItemClickListener{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        adapter.setData(data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private SimpleListAdapter<String>  adapter=new SimpleListAdapter<String>() {
        @Override
        public int getLayoutId() {
            return R.layout.list_item;
        }

        @Override
        public void onBindData(ViewHolder viewHolder, String itemData,int position) {
            viewHolder.setText(R.id.textView, itemData);
            viewHolder.setImageResource(R.id.imageView,position%2==0 ? R.drawable.icon_1:R.drawable.icon_2 );
        }
    };

    private List<String> data=Arrays.asList("测试BaseRecyclerAdapter","zxc");

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                toActivity(RecyclerViewActivity.class);
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

}
