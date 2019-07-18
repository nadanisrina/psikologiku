package com.nada.psikologiku.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nada.psikologiku.R;
import com.nada.psikologiku.model.History;

import java.util.ArrayList;

public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.HistoryViewHolder> {
    private ArrayList<History> dataList;

    public ListHistoryAdapter(ArrayList<History> dataList) {
        this.dataList = dataList;
    }
    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_history, parent, false);
        return new HistoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtKarakter.setText(dataList.get(position).getHasilKlasifikasi());
    }
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtKarakter;

        public  HistoryViewHolder(View v) {
            super(v);
            txtNama = (TextView) v.findViewById(R.id.nama);
            txtKarakter = (TextView) v.findViewById(R.id.hasil);
        }
    }
}
