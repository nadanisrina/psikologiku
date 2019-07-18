package com.nada.psikologiku;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

//import com.nada.psikologiku.adapter.ListQuizAdapter;

import com.nada.psikologiku.adapter.MyStresStepperAdapter;
import com.nada.psikologiku.database.DatabaseHelper;
import com.nada.psikologiku.model.Quiz;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuizStresActivity extends AppCompatActivity implements StepperLayout.StepperListener {
    private static final String TAG = "Quiz";
    private RecyclerView lvQuiz;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Quiz> mQuizList;
    private DatabaseHelper mDBHelper;
    private StepperLayout stepperLayout;
    private RadioGroup mRadioGroup;

    private List<String> saranList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_stres);

        stepperLayout = findViewById(R.id.stepperLayout);
        stepperLayout.setAdapter(new MyStresStepperAdapter(getSupportFragmentManager(), this));
        stepperLayout.setListener(this);

        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if (!database.exists()){
            mDBHelper.getReadableDatabase();
            if (copyDatabase(this)){
                Toast.makeText(this,"COPY SUCCESS",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"COPY ERROR",Toast.LENGTH_SHORT).show();
            }
        }
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

    @Override
    public void onCompleted(View completeButton) {
        saranList = new ArrayList<String>();
        mDBHelper = new DatabaseHelper(this);
        Log.e(TAG, "onCompleted: " + DatabaseHelper.HASIL);
        for (int i = 0; i < DatabaseHelper.HASIL.size(); i++) {
            String value = (String) DatabaseHelper.HASIL.get(i);
            String value1 = (String) DatabaseHelper.ANSWER.get(i);
            if (value.equals("0")) {
                DatabaseHelper.A += 1;
            } else if (value.equals("1")) {
                DatabaseHelper.B += 1;
                if (value1 != null){ saranList.add(value1);}

            } else if (value.equals("2")) {
                DatabaseHelper.C += 1;
                if (value1 != null){ saranList.add(value1);}
            }
        }


        int a = DatabaseHelper.A, b = DatabaseHelper.B, c = DatabaseHelper.C;
        int score =  b + c*2 ;

        if(score<13){
            Intent intent = new Intent(getApplicationContext(), HasilQuizStresActivity.class);
            intent.putExtra("pesan","Stres Ringan");
            intent.putExtra("score",score);
            Log.d(TAG, "ISISARAN: "+saranList);
            intent.putStringArrayListExtra("saran", (ArrayList<String>) saranList);
            startActivity(intent);
        }else if ((score>=13)){
            Intent intent = new Intent(getApplicationContext(), HasilQuizStresActivity.class);
            intent.putExtra("pesan","Stres Sedang");
            intent.putExtra("score",score);
            Log.d(TAG, "ISISARAN: "+saranList);
            intent.putStringArrayListExtra("saran", (ArrayList<String>) saranList);
            startActivity(intent);
        }
        Log.d(TAG, "jumlah: "+a+" "+b+" "+c+"");
        Log.d("score=","score"+score);
    }

    @Override
    public void onError(VerificationError verificationError) {
        Toast.makeText(this, "onError! -> " + verificationError.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStepSelected(int newStepPosition) {
        mRadioGroup = stepperLayout.findViewById(R.id.radioGroupWrapper);
        mRadioGroup.getCheckedRadioButtonId();
        Toast.makeText(this, "onStepSelected! -> " + newStepPosition +" " +
                ""+mRadioGroup.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReturn() {
        finish();
    }
}