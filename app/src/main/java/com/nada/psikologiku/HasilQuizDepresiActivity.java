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

import java.util.Date;

//import com.example.damar.finalproject.Hasil.AudioVisual1;
//import com.example.damar.finalproject.Menu.AudioKinestetikActivity;
//import com.example.damar.finalproject.Menu.AuditoriActivity;
//import com.example.damar.finalproject.Menu.KinestetikActivity;
//import com.example.damar.finalproject.Menu.VisualActivity;
//import com.example.damar.finalproject.Menu.VisualKinestetikActivity;

public class HasilQuizDepresiActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_hasil_quiz_depresi);
        TextView textView = (TextView) findViewById(R.id.hasil_quiz_depresi);
        Button button = (Button) findViewById(R.id.btn_back);
        Intent intent = getIntent();
        final String pesan = intent.getStringExtra("pesan");
        final Integer score = intent.getIntExtra("score",0);
        Log.d(TAG, "pesan : "+pesan);
        final String cekA = "Tidak ada tanda depresi";
        final String cekB = "Depresi Ringan";
        final String cekC = "Depresi Sedang";
        final String cekD = "Depresi Berat";
        final String cekE = "Depresi Sangat Berat";

        db = new SQLiteDatabaseHandler(this);
        textView.setText("Dari hasil skor anda yaitu "+ score +" Dapat disimpulkan anda mengalami "+ pesan);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    dialogForm();

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
        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama = txt_nama.getText().toString();

                Date tanggal = new Date();
                History player1 = new History(1, nama, pesan, "metodebelajar");
                db.addHistory(player1);

                dialogInterface.dismiss();

                    Intent intent = new Intent(HasilQuizDepresiActivity.this, MainActivity.class);
                    startActivity(intent);

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
