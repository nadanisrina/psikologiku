package com.nada.psikologiku.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.nada.psikologiku.model.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "psikologi.db";
    public static final String DBLOCATION = "/data/data/com.nada.psikologiku/databases/";
    public static Map HASIL = new HashMap();

    public static Map ANSWER = new HashMap();
    public static int A = 0 ;
    public static int B = 0 ;
    public static int C = 0 ;
    public static int D = 0 ;
    public static int E = 0 ;

    public static int A1 = 0 ;
    public static int B1 = 0 ;
    public static int C1 = 0 ;
    public static int D1 = 0 ;
    public static int E1 = 0 ;

    public static int A2 = 0 ;
    public static int B2 = 0 ;
    public static int C2 = 0 ;
    public static int D2 = 0 ;
    public static int E2 = 0 ;

//    public static ArrayList<String> saranList;
    private Context mContext;
    private SQLiteDatabase mDatabase;


    public DatabaseHelper(Context context){
        super(context,DBNAME,null,1);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
    public ArrayList<String> getSaran(String value1) {
        ArrayList<String> saranList = new ArrayList<String>();
        saranList.add(value1);

        return saranList;
    }
    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()){
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null,SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase(){
        if (mDatabase!=null){
            mDatabase.close();
        }
    }
    public List<Quiz> getQuestionByGroup (String index) {
        Quiz question = null;
        List<Quiz> QuestionList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            question = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            QuestionList.add(question);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return QuestionList;
    }

    public List<Quiz> getOption1ByGroup (String index) {
        Quiz option1 = null;
        List<Quiz> Option1List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option1 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option1List.add(option1);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option1List;
    }
    public List<Quiz> getOption2ByGroup (String index) {
        Quiz option2 = null;
        List<Quiz> Option2List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option2 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option2List.add(option2);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option2List;
    }
    public List<Quiz> getOption3ByGroup (String index) {
        Quiz option3 = null;
        List<Quiz> Option3List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option3 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option3List.add(option3);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option3List;
    }
    public List<Quiz> getOption4ByGroup (String index) {
        Quiz option4 = null;
        List<Quiz> Option4List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option4 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option4List.add(option4);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option4List;
    }
    public List<Quiz> getOption5ByGroup (String index) {
        Quiz option5 = null;
        List<Quiz> Option5List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option5 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option5List.add(option5);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option5List;
    }

//anxiety

    public List<Quiz> getQuestionDepresiByGroup (String index) {
        Quiz question = null;
        List<Quiz> QuestionList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            question = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            QuestionList.add(question);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return QuestionList;
    }

    public List<Quiz> getOption1DepresiByGroup (String index) {
        Quiz option1 = null;
        List<Quiz> Option1List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option1 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option1List.add(option1);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option1List;
    }
    public List<Quiz> getOption2DepresiByGroup (String index) {
        Quiz option2 = null;
        List<Quiz> Option2List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option2 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option2List.add(option2);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option2List;
    }
    public List<Quiz> getOption3DepresiByGroup (String index) {
        Quiz option3 = null;
        List<Quiz> Option3List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option3 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option3List.add(option3);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option3List;
    }
    public List<Quiz> getOption4DepresiByGroup (String index) {
        Quiz option4 = null;
        List<Quiz> Option4List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option4 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option4List.add(option4);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option4List;
    }
    public List<Quiz> getOption5DepresiByGroup (String index) {
        Quiz option5 = null;
        List<Quiz> Option5List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option5 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option5List.add(option5);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option5List;
    }
//stres
public List<Quiz> getQuestionStresByGroup (String index) {
    Quiz question = null;
    List<Quiz> QuestionList = new ArrayList<>();
    openDatabase();
    Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_stres q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
    cursor.moveToFirst();
    while (!cursor.isAfterLast()){
        question = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
        QuestionList.add(question);
        cursor.moveToNext();
    }

    cursor.close();
    closeDatabase();
    return QuestionList;
}

    public List<Quiz> getOption1StresByGroup (String index) {
        Quiz option1 = null;
        List<Quiz> Option1List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_stres q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option1 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option1List.add(option1);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option1List;
    }
    public List<Quiz> getOption2StresByGroup (String index) {
        Quiz option2 = null;
        List<Quiz> Option2List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_stres q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option2 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option2List.add(option2);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option2List;
    }
    public List<Quiz> getOption3StresByGroup (String index) {
        Quiz option3 = null;
        List<Quiz> Option3List = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_stres q WHERE q.group_index = ? ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            option3 = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            Option3List.add(option3);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return Option3List;
    }
    public List<Quiz> getSaranStresByGroup (String index) {
        Quiz saran = null;
        List<Quiz> SaranList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_stres q WHERE q.group_index = ?  ORDER BY q.id ASC",new String[] {index});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            saran = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            SaranList.add(saran);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return SaranList;
    }

    public List<Quiz> getSaranStres () {
        Quiz saran = null;
        List<Quiz> SaranList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_stres WHERE saran is not null",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            saran = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            SaranList.add(saran);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return SaranList;
    }

    public List<Quiz> getSaranKecemasan () {
        Quiz saran = null;
        List<Quiz> SaranList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question WHERE saran is not null",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            saran = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            SaranList.add(saran);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return SaranList;
    }

    public List<Quiz> getSaranDepresi () {
        Quiz saran = null;
        List<Quiz> SaranList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM question_depresi WHERE saran is not null",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            saran = new Quiz(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            SaranList.add(saran);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return SaranList;
    }



}
