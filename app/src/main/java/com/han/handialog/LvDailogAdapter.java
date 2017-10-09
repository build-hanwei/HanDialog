package com.han.handialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class LvDailogAdapter extends BaseAdapter {
	protected Context mContext;
	private List<Map> mList;//数据集合

	public LvDailogAdapter(Context context, List<Map> mList) {
		this.mContext = context;
		this.mList = mList;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		view = View.inflate(mContext, R.layout.listview_dialog_item,null);
		TextView tvName = (TextView) view.findViewById(R.id.tv_dialog_item);
		String name = mList.get(position).get("name") + "";
		tvName.setText(name);

		return view;
	}
}
