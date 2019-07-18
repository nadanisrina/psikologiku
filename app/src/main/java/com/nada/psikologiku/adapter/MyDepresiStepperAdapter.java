package com.nada.psikologiku.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.nada.psikologiku.fragment.QuizDepresiFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class MyDepresiStepperAdapter extends AbstractFragmentStepAdapter {

    public static final String CURRENT_STEP_POSITION_KEY = "CURRENT_STEP_POSITION_KEY";

    public MyDepresiStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        final QuizDepresiFragment step = new QuizDepresiFragment();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 17;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        return new StepViewModel.Builder(context)
                .setTitle("Fragment " + getCount()) //can be a CharSequence instead
                .create();
    }
}
