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

public class ListSaranStresAdapter extends BaseAdapter{
    private Context mContext;
    private List<Quiz> mSaranStresList;

    public ListSaranStresAdapter(Context mContext, List<Quiz> mSaranStresList) {
        this.mContext = mContext;
        this.mSaranStresList = mSaranStresList;
    }

    @Override
    public int getCount() {
        return mSaranStresList.size();
    }

    @Override
    public Object getItem(int i) {
        return mSaranStresList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mSaranStresList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(mContext, R.layout.item_listview,null);

        TextView txtSaranStres = (TextView)v.findViewById(R.id.txtSaranStres);
        txtSaranStres.setText(mSaranStresList.get(i).getSaran());
        txtSaranStres.setTextColor(Color.BLACK);
        if (i % 2 == 0) {
            v.setBackgroundColor(Color.WHITE);

        } else {
            v.setBackgroundColor(Color.rgb(242, 242, 242));

        }


        return v;
    }
}
