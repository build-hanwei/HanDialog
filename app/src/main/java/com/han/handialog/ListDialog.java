package com.han.handialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListDialog implements View.OnClickListener {
    private Context context;
    public Dialog dialog;
    private TextView title;
    private ListView listview;
    private List<Map> data = new ArrayList<Map>();

    public ListDialog(final Context context) {
        this.context = context;
        //自定义dialog
        dialog = new Dialog(context, R.style.dialog);//Dialog的Style
        Window window = dialog.getWindow();
        window.setContentView(R.layout.listview_dialog);//引用Dialog的布局

        title = (TextView) window.findViewById(R.id.tv_title);
        listview = (ListView) window.findViewById(R.id.lv_dialog);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String name = data.get(position).get("name") + "";
                Toast.makeText(context, "下标" + position + "----" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setTitle(String titleStr) {
        title.setText(titleStr);
    }

    public void setList(List<Map> data) {
        this.data = data;
        listview.setAdapter(new LvDailogAdapter(context, data));//ListView设置适配器
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
        }
    }
}