package com.nada.psikologiku.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.List;
import com.nada.psikologiku.R;
import com.nada.psikologiku.model.Quiz;

import java.util.List;

public class ListSaranDepresiAdapter extends BaseAdapter{
    private Context mContext;
    private List<Quiz> mSaranDepresiList;

    public ListSaranDepresiAdapter(Context mContext, List<Quiz> mSaranDepresiList) {
        this.mContext = mContext;
        this.mSaranDepresiList = mSaranDepresiList;
    }

    @Override
    public int getCount() {
        return mSaranDepresiList.size();
    }

    @Override
    public Object getItem(int i) {
        return mSaranDepresiList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mSaranDepresiList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.item_listview,null);
        TextView txtSaranStres = (TextView)v.findViewById(R.id.txtSaranStres);
        txtSaranStres.setText(mSaranDepresiList.get(i).getSaran());

        return v;
    }
}
