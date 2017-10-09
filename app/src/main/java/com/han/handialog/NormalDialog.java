package com.han.handialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class NormalDialog implements View.OnClickListener {
    private Context context;
    public Dialog dialog;
    public TextView title, cancle, ok;
    private MyDialogOnClick myDialogOnClick;
    private MyDialogNoOnClick myDialogNoOnClick;

    public NormalDialog(Context context) {
        this.context = context;
        //自定义dialog
        dialog = new Dialog(context, R.style.dialog);//Dialog的Style
        Window window = dialog.getWindow();
        window.setContentView(R.layout.normal_dialog);//引用Dialog的布局

        title = (TextView) window.findViewById(R.id.tv_title);
        cancle = (TextView) window.findViewById(R.id.btn_cancel);
        ok = (TextView) window.findViewById(R.id.btn_ok);

        cancle.setOnClickListener(this);
        ok.setOnClickListener(this);
    }

    public void setTitle(String titleStr) {
        title.setText(titleStr);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                dialog.cancel();
                myDialogOnClick.ok();
                break;
            case R.id.btn_cancel:
                dialog.cancel();
                if (myDialogNoOnClick != null) {
                    myDialogNoOnClick.no();
                }
                break;

        }
    }

    //给确认按钮设置回调的接口
    public interface MyDialogOnClick{
        void ok();
    }

    //给否按钮设置回调的接口
    public interface MyDialogNoOnClick{
        void no();
    }

    public void setMyDialogOnClick(MyDialogOnClick myDialogOnClick){
        this.myDialogOnClick = myDialogOnClick;
    }

    public void setMyDialogNoOnClick(MyDialogNoOnClick myDialogOnClick){
        this.myDialogNoOnClick = myDialogOnClick;
    }
}