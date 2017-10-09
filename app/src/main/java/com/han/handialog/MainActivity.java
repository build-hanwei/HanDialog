package com.han.handialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义效果的弹窗
 *
 * @author hanwei
 * @time 2017年10月9日 16:05:49
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnNormal, btnListview;//btnNormal点击弹出普通的弹窗，btnListview点击弹出带listview的弹窗

    private List<Map> data = new ArrayList<Map>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNormal = (Button) findViewById(R.id.btn_normal);
        btnListview = (Button) findViewById(R.id.btn_listview);

        btnNormal.setOnClickListener(this);
        btnListview.setOnClickListener(this);

        Map map = new HashMap();
        map.put("name", "1111");
        data.add(map);
        map = new HashMap();
        map.put("name", "2222");
        data.add(map);
        map = new HashMap();
        map.put("name", "3333");
        data.add(map);
        map = new HashMap();
        map.put("name", "4444");
        data.add(map);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                NormalDialog normalDialog = new NormalDialog(MainActivity.this);
                normalDialog.setTitle("皮皮虾，我们走");
                normalDialog.dialog.show();

                //重定义下确定的文本
                normalDialog.ok.setText("走");
                //确认按键回调，按下确认后在此做处理
                normalDialog.setMyDialogOnClick(new NormalDialog.MyDialogOnClick() {
                    @Override
                    public void ok() {
                        Toast.makeText(MainActivity.this, "走喽", Toast.LENGTH_SHORT).show();
                    }
                });

                //重定义下取消的文本
                normalDialog.cancle.setText("不走");
                //取消按键回调，按下取消后在此做处理
                normalDialog.setMyDialogNoOnClick(new NormalDialog.MyDialogNoOnClick() {
                    @Override
                    public void no() {
                        Toast.makeText(MainActivity.this, "走你妹", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_listview:
                ListDialog dia = new ListDialog(MainActivity.this);
                dia.setTitle("皮皮虾，我们走");
                dia.setList(data);
                dia.dialog.show();
                break;
        }
    }
}
