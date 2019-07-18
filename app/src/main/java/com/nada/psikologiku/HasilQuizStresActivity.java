package com.nada.psikologiku;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nada.psikologiku.database.SQLiteDatabaseHandler;
import com.nada.psikologiku.model.History;

import java.util.ArrayList;
import java.util.Date;

//import com.example.damar.finalproject.Hasil.AudioVisual1;
//import com.example.damar.finalproject.Menu.AudioKinestetikActivity;
//import com.example.damar.finalproject.Menu.AuditoriActivity;
//import com.example.damar.finalproject.Menu.KinestetikActivity;
//import com.example.damar.finalproject.Menu.VisualActivity;
//import com.example.damar.finalproject.Menu.VisualKinestetikActivity;

public class HasilQuizStresActivity extends AppCompatActivity {
    private static final String TAG = "Hasil Act";
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_nama;
    TextView txt_hasil;
    String nama;
    Button btn_simpan;
    private SQLiteDatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz_stres);
//        TextView textView = (TextView) findViewById(R.id.hasil_quiz_stres);
        TextView skor_quiz_stres = (TextView) findViewById(R.id.skor_quiz_stres);
        TextView hasil_quiz_stres = (TextView) findViewById(R.id.hasil_quiz_stres);
        TextView hasil_saran_stres = (TextView) findViewById(R.id.hasil_saran_stres);
        Button button = (Button) findViewById(R.id.btn_lanjut);
        Intent intent = getIntent();
        final String pesan = intent.getStringExtra("pesan");
        final Integer score = intent.getIntExtra("score",0);
        final ArrayList<String> saran = getIntent().getStringArrayListExtra("saran");

        Log.d(TAG, "pesan : "+pesan);
        final String cekA = "Stres Ringan";
        final String cekB = "Stres Sedang";
        db = new SQLiteDatabaseHandler(this);

        skor_quiz_stres.setText(""+score);
        hasil_quiz_stres.setText(pesan);
        hasil_saran_stres.setText(""+saran);
//        textView.setText("Dari hasil skor anda yaitu "+ score +" Dapat disimpulkan anda mengalami "+ pesan + " Saran Untuk anda " + saran);
        if (pesan.equals(cekA)){
            button.setText("Kembali");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pesan.equals(cekB)){
                    dialogForm();
                } else if (pesan.equals(cekA)){
                    dialogForm();
                } else {
                    Toast.makeText(HasilQuizStresActivity.this,"GAGAL",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void dialogForm() {

        Log.d("mbarang", "onClick: klik");
        dialog = new AlertDialog.Builder(this, R.style.myDialog);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_template, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Simpan hasil tes");

        txt_nama = (EditText) dialogView.findViewById(R.id.input_nama);


        Intent intent = getIntent();
        final String pesan = intent.getStringExtra("pesan");
        final String cekA = "Stres Ringan";
        final String cekB = "Stres Sedang";
        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama = txt_nama.getText().toString();

                Date tanggal = new Date();
                History player1 = new History(1, nama, pesan, "metodebelajar");
                db.addHistory(player1);

                dialogInterface.dismiss();
                if (pesan.equals(cekB)){
                    Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                    startActivity(intent);
                } else if (pesan.equals(cekA)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        }).create();

        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });

        dialog.show();
    }
}
