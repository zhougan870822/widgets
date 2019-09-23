package com.zhoug.widget.module;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhoug.android.widget.adapters.SimpleListAdapter;
import com.zhoug.android.widget.dialog.ButtonDialog;
import com.zhoug.android.widget.dialog.EditDialogFragment;
import com.zhoug.widget.module.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity implements ListView.OnItemClickListener {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        adapter.setData(data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private SimpleListAdapter<String> adapter = new SimpleListAdapter<String>() {
        @Override
        public int getLayoutId() {
            return R.layout.list_item;
        }

        @Override
        public void onBindData(ViewHolder viewHolder, String itemData, int position) {
            viewHolder.setText(R.id.textView, itemData);
            viewHolder.setImageResource(R.id.imageView, position % 2 == 0 ? R.drawable.icon_1 : R.drawable.icon_2);
        }
    };

    private List<String> data = Arrays.asList("测试BaseRecyclerAdapter",
            "ButtonDialog","EditDialogFragment","1","1","1","1","1","1","1","1");

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                toActivity(RecyclerViewActivity.class);
                break;
            case 1:
                ButtonDialog  buttonDialog = new ButtonDialog(this, "zxczxc");
                buttonDialog.setCircle(false);
                buttonDialog.setTitle("你好");

                buttonDialog.setOnclickListener1("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast("确定");
                        buttonDialog.cancel();

                    }
                });
                buttonDialog.setOnclickListener2("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast("取消");
                        buttonDialog.cancel();

                    }
                });
                buttonDialog.show();

                break;
            case 2:
                EditDialogFragment editDialogFragment=new EditDialogFragment();
                editDialogFragment.setTitle("爱评论的你是个好人");
                editDialogFragment.setTextSize(14);
                editDialogFragment.setTitleSize(16);
                editDialogFragment.setConfirmOnclickListener(value -> {
                    toast(value);
                });
                editDialogFragment.show(getSupportFragmentManager(), EditDialogFragment.class.getName());
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
        }
    }

}
