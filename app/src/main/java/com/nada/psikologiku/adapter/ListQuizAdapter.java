//package com.nada.psikologiku.adapter;
//
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//
//import com.nada.psikologiku.R;
//import com.nada.psikologiku.database.DatabaseHelper;
//import com.nada.psikologiku.model.Klasifikasi;
//import com.nada.psikologiku.model.Quiz;
//
//import java.util.ArrayList;
//import java.util.List;
//public class ListQuizAdapter extends RecyclerView.Adapter<ListQuizAdapter.QuizViewHolder>{
//    private Context mContext;
//    private List<Quiz> mQuizList;
//    private DatabaseHelper mDBHelper;
//    public static ArrayList<String> selectedAnswers;
//    public ListQuizAdapter(Context mContext, List<Quiz> mQuizList) {
//        this.mContext = mContext;
//        this.mQuizList = mQuizList;
//        this.selectedAnswers = new ArrayList<>();
//        this.mDBHelper = new DatabaseHelper(mContext);
//    }
//    @NonNull
//    @Override
//    public ListQuizAdapter.QuizViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        View view = layoutInflater.inflate(R.layout.item_listklasifikasi, viewGroup, false); //edit
//
//        QuizViewHolder quizViewHolder = new QuizViewHolder(view);
//        quizViewHolder.setIsRecyclable(false);
//
//        return quizViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull QuizViewHolder quizViewHolder, int i) {
//        final List<Quiz> lk = mDBHelper.getListQuizByGroup(String.valueOf(mQuizList.get(i).getJenis_quiz_id()));
//        final RadioButton[] rb = new RadioButton[lk.size()];
//
//        for (int j = 0; j < lk.size(); j++) {
//            Quiz kl = lk.get(j);
//            rb[j] = new RadioButton(mContext);
//            rb[j].setId(j);
//            rb[j].setText(kl.getOption1());
//            quizViewHolder.radioGroup.addView(rb[j]);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return mQuizList.size();
//    }
//
//    public class QuizViewHolder extends RecyclerView.ViewHolder{
//        private RadioGroup radioGroup;
//        public QuizViewHolder(@NonNull View itemView) {
//            super(itemView);
//            radioGroup = itemView.findViewById(R.id.radioGroupWrapper);
//        }
//
//    }
//}
