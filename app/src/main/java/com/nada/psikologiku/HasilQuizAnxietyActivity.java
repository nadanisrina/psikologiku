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

public class HasilQuizAnxietyActivity extends AppCompatActivity {
    private static final String TAG = "Hasil Act";
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_nama;
    TextView txt_hasil;
    String nama1;
    Button btn_simpan;
    private SQLiteDatabaseHandler db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz_anxiety);
        TextView textView = (TextView) findViewById(R.id.hasil_quiz_anxiety);
        Button button = (Button) findViewById(R.id.btn_lanjut);
        Intent intent = getIntent();
        db1 = new SQLiteDatabaseHandler(this);
        final String pesan1 = intent.getStringExtra("pesan1");
        final Integer score1 = intent.getIntExtra("score1",0);
        Log.d(TAG, "pesan : "+pesan1);
        final String cekA = "Tidak ada Kecemasan";
        final String cekB = "Kecemasan Ringan";
        final String cekC = "Kecemasan Sedang";
        final String cekD = "Kecemasan Berat";
        final String cekE = "Kecemasan Sangat Berat";
        textView.setText("Dari hasil skor anda yaitu "+ score1 +" Dapat disimpulkan anda mengalami "+ pesan1);
        if (pesan1.equals(cekA)||pesan1.equals(cekB)){
            button.setText("Kembali");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pesan1.equals(cekA)){
                    dialogForm();
                } else if (pesan1.equals(cekB)){
                    dialogForm();
                } else if (pesan1.equals(cekC)) {
                    dialogForm();
                } else if (pesan1.equals(cekD)) {
                    dialogForm();
                } else if (pesan1.equals(cekE)) {
                    dialogForm();
                } else {
                    Toast.makeText(HasilQuizAnxietyActivity.this,"GAGAL",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void dialogForm() {

        Log.d("mbarang", "onClick: klik");
        dialog = new AlertDialog.Builder(this, R.style.myDialog);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_template_anxiety, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Simpan hasil tes");

        txt_nama = (EditText) dialogView.findViewById(R.id.input_nama1);
        Intent intent = getIntent();
        final String pesan1 = intent.getStringExtra("pesan1");

        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama1 = txt_nama.getText().toString();

                Date tanggal = new Date();
                Log.d(TAG, "dialogForm: "+pesan1 +nama1);
                History player2 = new History(2, nama1, pesan1, "metodebelajar");
                db1.addHistory(player2);

                dialogInterface.dismiss();
                final String cekA = "Tidak ada Kecemasan";
                final String cekB = "Kecemasan Ringan";
                final String cekC = "Kecemasan Sedang";
                final String cekD = "Kecemasan Berat";
                final String cekE = "Kecemasan Sangat Berat";
                if (pesan1.equals(cekA)){
                    Intent intent = new Intent(HasilQuizAnxietyActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (pesan1.equals(cekB)){
                    Intent intent = new Intent(HasilQuizAnxietyActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (pesan1.equals(cekC)) {
                    Intent intent = new Intent(HasilQuizAnxietyActivity.this, QuizDepresiActivity.class);
                    startActivity(intent);
                } else if (pesan1.equals(cekD)) {
                    Intent intent = new Intent(HasilQuizAnxietyActivity.this, QuizDepresiActivity.class);
                    startActivity(intent);
                } else if (pesan1.equals(cekE)) {
                    Intent intent = new Intent(HasilQuizAnxietyActivity.this, QuizDepresiActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(HasilQuizAnxietyActivity.this,"GAGAL",Toast.LENGTH_SHORT).show();
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
