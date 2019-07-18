package com.nada.psikologiku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nada.psikologiku.database.SQLiteDatabaseHandler;

public class PilihSaranActivity extends AppCompatActivity {
    LinearLayout btn_stres,btn_kecemasan;
    private SQLiteDatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_saran);

        btn_stres = (LinearLayout) findViewById(R.id.btn_stres);
        btn_stres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSaranStres();
            }
        });
        btn_kecemasan = (LinearLayout) findViewById(R.id.btn_kecemasan);
        btn_kecemasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSaranKecemasan();
            }
        });
//        btn_depresi = (LinearLayout) findViewById(R.id.btn_depresi);
//        btn_depresi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openSaranDepresi();
//            }
//        });

    }
    public void openSaranStres(){
        Intent intent = new Intent(this,SaranStresActivity.class);
        startActivity(intent);
    }
    public void openSaranKecemasan(){
        Intent intent = new Intent(this,SaranKecemasanActivity.class);
        startActivity(intent);
    }
//    public void openSaranDepresi(){
//        Intent intent = new Intent(this,SaranDepresiActivity.class);
//        startActivity(intent);
//    }
}

