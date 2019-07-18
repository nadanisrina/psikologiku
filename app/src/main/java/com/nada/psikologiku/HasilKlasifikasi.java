//package com.nada.psikologiku;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
////import com.example.damar.finalproject.Hasil.AudioVisual1;
////import com.example.damar.finalproject.Menu.AudioKinestetikActivity;
////import com.example.damar.finalproject.Menu.AuditoriActivity;
////import com.example.damar.finalproject.Menu.KinestetikActivity;
////import com.example.damar.finalproject.Menu.VisualActivity;
////import com.example.damar.finalproject.Menu.VisualKinestetikActivity;
//
//public class HasilKlasifikasi extends AppCompatActivity {
//
//    private static final String TAG = "Hasil Act";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hasil_klasifikasi);
//        TextView textView = (TextView) findViewById(R.id.hasil_klasifikasi);
//        Button button = (Button) findViewById(R.id.btn_metodebelajar);
//        Intent intent = getIntent();
//        final String pesan = intent.getStringExtra("pesan");
//        final Integer score = intent.getIntExtra("score",0);
//        Log.d(TAG, "pesan : "+pesan);
//        final String cekA = "Tidak ada Kecemasan";
//        final String cekB = "Kecemasan Ringan";
//        final String cekC = "Kecemasan Sedang";
//        final String cekD = "Kecemasan Berat";
//        final String cekE = "Kecemasan Sangat Berat";
//        textView.setText("Dari hasil skor anda yaitu"+ score +" Dapat disimpulkan anda mengalami"+ pesan);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (pesan.equals(cekA)){
//                    Intent i = new Intent(HasilKlasifikasi.this, AuditoriActivity.class);
//                    startActivity(i);
//                } else if (pesan.equals(cekB)){
//                    Intent i = new Intent(HasilKlasifikasi.this, VisualActivity.class);
//                    startActivity(i);
//                } else if (pesan.equals(cekC)) {
//                    Intent i = new Intent(HasilKlasifikasi.this, KinestetikActivity.class);
//                    startActivity(i);
//                } else if (pesan.equals(cekD)) {
//                    Intent i = new Intent(HasilKlasifikasi.this, AudioKinestetikActivity.class);
//                    startActivity(i);
//                } else if (pesan.equals(cekE)) {
//                    Intent i = new Intent(HasilKlasifikasi.this, AudioVisual1.class);
//                    startActivity(i);
//                } else if (pesan.equals(cekF)) {
//                    Intent i = new Intent(HasilKlasifikasi.this, VisualKinestetikActivity.class);
//                    startActivity(i);
//                } else {
//                    Toast.makeText(HasilKlasifikasi.this,"GAGAL",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }
//}
