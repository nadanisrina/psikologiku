package com.nada.psikologiku;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.nada.psikologiku.adapter.ListHistoryAdapter;
import com.nada.psikologiku.database.SQLiteDatabaseHandler;
import com.nada.psikologiku.model.History;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG = "as";
    private SQLiteDatabaseHandler db;
    private RecyclerView recyclerView;
    private ListHistoryAdapter adapter;
    List<History> histories;
    ArrayList<History> listhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        db = new SQLiteDatabaseHandler(this);

        histories = db.allPlayers();
        iniData();

//        Toast.makeText( getApplicationContext(),"onCreate: mashok", Toast.LENGTH_SHORT ).show();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new ListHistoryAdapter(listhistory);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    public void iniData() {
        listhistory = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++) {
            History h = new History();
            h.setId(histories.get(i).getId());
            h.setHasilKlasifikasi(histories.get(i).getHasilKlasifikasi());
            h.setMetode(histories.get(i).getMetode());
            h.setNama(histories.get(i).getNama());
            listhistory.add(h);
        }
    }
}
