package com.nada.psikologiku.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.List;
import com.nada.psikologiku.R;
import com.nada.psikologiku.model.Quiz;

import java.util.List;

public class ListSaranKecemasanAdapter extends BaseAdapter{
    private Context mContext;
    private List<Quiz> mSaranKecemasanList;

    public ListSaranKecemasanAdapter(Context mContext, List<Quiz> mSaranKecemasanList) {
        this.mContext = mContext;
        this.mSaranKecemasanList = mSaranKecemasanList;
    }

    @Override
    public int getCount() {
        return mSaranKecemasanList.size();
    }

    @Override
    public Object getItem(int i) {
        return mSaranKecemasanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mSaranKecemasanList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.item_listview,null);
        TextView txtSaranKecemasan = (TextView)v.findViewById(R.id.txtSaranStres);
        txtSaranKecemasan.setText(mSaranKecemasanList.get(i).getSaran());
        txtSaranKecemasan.setTextColor(Color.BLACK);
        if (i % 2 == 0) {
            v.setBackgroundColor(Color.WHITE);

        } else {
            v.setBackgroundColor(Color.rgb(242, 242, 242));

        }

        return v;
    }
}
