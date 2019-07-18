package com.nada.psikologiku.fragment;


import android.content.ContentValues;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nada.psikologiku.R;
import com.nada.psikologiku.adapter.MyStresStepperAdapter;
import com.nada.psikologiku.database.DatabaseHelper;
import com.nada.psikologiku.model.Quiz;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizStresFragment extends Fragment implements Step {


    public QuizStresFragment() {
        // Required empty public constructor
    }
    TextView Question;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton1;
    RadioButton mRadioButton2;
    RadioButton mRadioButton3;
    Integer answerChecked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Bundle bundle = this.getArguments();
        Log.d("##", "onCreateView: " + bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY));

        final View view = inflater.inflate(R.layout.fragment_step_stres, container, false);

        Question = view.findViewById(R.id.question);
        mRadioGroup = view.findViewById(R.id.radioGroupWrapper);

        mRadioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        DatabaseHelper mDBHelper = new DatabaseHelper(getContext());
                        RadioButton checkedRadioButton = (RadioButton) view.findViewById(i);
//                        String text = String.valueOf(checkedRadioButton.getId())+" "+String.valueOf(bundle.getInt(MyStepperAdapter.CURRENT_STEP_POSITION_KEY));
                        DatabaseHelper.HASIL.put(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY), checkedRadioButton.getHint());
                        final List<Quiz> saran = mDBHelper.getSaranStresByGroup(String.valueOf(Integer.valueOf(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY)) + 1));
                        Quiz s = saran.get(0);

                        DatabaseHelper.ANSWER.put(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY), s.getSaran());


//                        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();

                    }
                });


        DatabaseHelper mDBHelper = new DatabaseHelper(getContext());
        Log.d("#######", String.valueOf(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY)));
        final List<Quiz> lk = mDBHelper.getQuestionStresByGroup(String.valueOf(Integer.valueOf(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY)) + 1));
        final List<Quiz> op1 = mDBHelper.getOption1StresByGroup(String.valueOf(Integer.valueOf(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY)) + 1));
        final List<Quiz> op2 = mDBHelper.getOption2StresByGroup(String.valueOf(Integer.valueOf(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY)) + 1));
        final List<Quiz> op3 = mDBHelper.getOption3StresByGroup(String.valueOf(Integer.valueOf(bundle.getInt(MyStresStepperAdapter.CURRENT_STEP_POSITION_KEY)) + 1));



        final RadioButton[] rb = new RadioButton[lk.size()];
        Log.d("##sz", "onCreateView: " + lk.size()) ;


        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[] {
                Color.BLACK,
                Color.BLACK,
                Color.BLACK,
                Color.BLACK
        };

        mRadioButton1 = view.findViewById(R.id.checkbox0);
        mRadioButton2 = view.findViewById(R.id.checkbox1);
        mRadioButton3 = view.findViewById(R.id.checkbox2);


        if(lk.size() > 0) {
            Quiz k15 = lk.get(0);
            Question.setText(k15.getQuestion());
        }

//        if(lk.size() > 0) {
        Quiz kl0 = op1.get(0);
        Quiz kl1 = op2.get(0);
        Quiz kl2 = op3.get(0);

        mRadioButton1.setText(kl0.getOption1());
        mRadioButton2.setText(kl1.getOption2());
        mRadioButton3.setText(kl2.getOption3());


//        }

        return view;
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}
