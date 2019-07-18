//package com.nada.psikologiku;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.View;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//import com.nada.psikologiku.adapter.MyStepperAdapter;
//import com.nada.psikologiku.database.DatabaseHelper;
//import com.nada.psikologiku.model.Klasifikasi;
//import com.stepstone.stepper.StepperLayout;
//import com.stepstone.stepper.VerificationError;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.List;
//
//public class KlasifikasiActivity extends AppCompatActivity implements StepperLayout.StepperListener {
//    private static final String TAG = "Klasifikasi";
//    private RecyclerView lvKlasifikasi;
//    private RecyclerView.Adapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//    private List<Klasifikasi> mKlasifikasiList;
//    private DatabaseHelper mDBHelper;
//    private StepperLayout stepperLayout;
//    private RadioGroup mRadioGroup;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_klasifikasi);
//
//        stepperLayout = findViewById(R.id.stepperLayout);
//        stepperLayout.setAdapter(new MyStepperAdapter(getSupportFragmentManager(), this));
//        stepperLayout.setListener(this);
//
//        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
//        if (!database.exists()){
//            mDBHelper.getReadableDatabase();
//            if (copyDatabase(this)){
//                Toast.makeText(this,"COPY SUCCESS",Toast.LENGTH_SHORT).show();
//            }else {
//                Toast.makeText(this,"COPY ERROR",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private boolean copyDatabase(Context context) {
//        try {
//            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
//            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
//            OutputStream outputStream = new FileOutputStream(outFileName);
//            byte[] buff = new byte[1024];
//            int length = 0;
//            while ((length = inputStream.read(buff)) > 0){
//                outputStream.write(buff,0,length);
//            }
//            outputStream.flush();
//            outputStream.close();
//            Log.w("MainActivity","DB copied");
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public void onCompleted(View completeButton) {
//        Log.e(TAG, "onCompleted: " + DatabaseHelper.HASIL);
//        for (int i = 0; i < DatabaseHelper.HASIL.size(); i++) {
//            String value = (String) DatabaseHelper.HASIL.get(i);
//            if (value.equals("0")) {
//                DatabaseHelper.AUDITORI += 1;
//            } else if (value.equals("1")) {
//                DatabaseHelper.VISUAL += 1;
//            } else {
//                DatabaseHelper.KINESTETIK += 1;
//            }
//        }
//
//        int a = DatabaseHelper.AUDITORI, v = DatabaseHelper.VISUAL, k = DatabaseHelper.KINESTETIK;
//        if (a > k && a > v) {
//            Intent intent = new Intent(getApplicationContext(), HasilKlasifikasi.class);
//            intent.putExtra("pesan","Auditori");
//            startActivity(intent);
//
//        } else if (v > a && v > k) {
//            Intent intent = new Intent(getApplicationContext(), HasilKlasifikasi.class);
//            intent.putExtra("pesan","Visual");
//            startActivity(intent);
//
//        } else if (k > a && k > v) {
//            Intent intent = new Intent(getApplicationContext(), HasilKlasifikasi.class);
//            intent.putExtra("pesan","Kinestetik");
//            startActivity(intent);
//
//        } else if (a == k && a > v) {
//            Intent intent = new Intent(getApplicationContext(), HasilKlasifikasi.class);
//            intent.putExtra("pesan","AudioKinestetik");
//            startActivity(intent);
//
//        } else if (a == v && a > k) {
//            Intent intent = new Intent(getApplicationContext(), HasilKlasifikasi.class);
//            intent.putExtra("pesan","AudioVisual");
//            startActivity(intent);
//
//        } else if (v == k && v > a) {
//            Intent intent = new Intent(getApplicationContext(), HasilKlasifikasi.class);
//            intent.putExtra("pesan","VisualKinestetik");
//            startActivity(intent);
//
//        } else {
//            Toast.makeText(getApplicationContext(), "Anak itu Gataudah", Toast.LENGTH_SHORT).show();
//        }
//        Log.d(TAG, "jumlah: "+a+" "+v+" "+k);
//    }
//
//    @Override
//    public void onError(VerificationError verificationError) {
//        Toast.makeText(this, "onError! -> " + verificationError.getErrorMessage(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onStepSelected(int newStepPosition) {
//        mRadioGroup = stepperLayout.findViewById(R.id.radioGroupWrapper);
//        mRadioGroup.getCheckedRadioButtonId();
//        Toast.makeText(this, "onStepSelected! -> " + newStepPosition +" " +
//                ""+mRadioGroup.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onReturn() {
//        finish();
//    }
//}
