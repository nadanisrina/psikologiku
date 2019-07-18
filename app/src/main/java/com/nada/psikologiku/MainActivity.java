package com.nada.psikologiku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.nada.psikologiku.database.SQLiteDatabaseHandler;

public class MainActivity extends AppCompatActivity {
    LinearLayout btn_quiz, btn_history, btn_saran, btn_about;
    private SQLiteDatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_quiz = (LinearLayout) findViewById(R.id.btn_quiz);
        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz();
            }
        });
        btn_history = (LinearLayout) findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHistory();
            }
        });
        btn_saran = (LinearLayout) findViewById(R.id.btn_saran);
        btn_saran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSaran();
            }
        });
        btn_about = (LinearLayout) findViewById(R.id.btn_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbout();
            }
        });
        db = new SQLiteDatabaseHandler(this);
    }
    public void openQuiz(){
        Intent intent = new Intent(this,QuizStresActivity.class);
        startActivity(intent);
    }
    public void openHistory(){
        Intent intent = new Intent(this,HistoryActivity.class);
        startActivity(intent);
    }
    public void openSaran(){
        Intent intent = new Intent(this,PilihSaranActivity.class);
        startActivity(intent);
    }
    public void openAbout(){
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }
}
