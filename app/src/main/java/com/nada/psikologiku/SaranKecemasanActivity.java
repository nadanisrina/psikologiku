package com.nada.psikologiku;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.nada.psikologiku.adapter.ListSaranKecemasanAdapter;
import com.nada.psikologiku.database.DatabaseHelper;
import com.nada.psikologiku.model.Quiz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class SaranKecemasanActivity extends AppCompatActivity {
    private ListView lvSaranKecemasan;
    private ListSaranKecemasanAdapter adapter;
    private List<Quiz> mSaranKecemasanList;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran_kecemasan);

        lvSaranKecemasan = (ListView)findViewById(R.id.listview_kecemasan);
        mDBHelper = new DatabaseHelper(this);

        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if (false == database.exists()){
            mDBHelper.getReadableDatabase();
            if (copyDatabase(this)){
                Toast.makeText(this,"COPY SUCCESS",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"COPY ERROR",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        //get db metode
        mSaranKecemasanList = mDBHelper.getSaranKecemasan();
        adapter = new ListSaranKecemasanAdapter(this,mSaranKecemasanList);
        lvSaranKecemasan.setAdapter(adapter);


    }
    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0){
                outputStream.write(buff,0,length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
