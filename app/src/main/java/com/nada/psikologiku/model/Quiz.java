package com.nada.psikologiku.model;

public class Quiz {
    private int id;
    private Integer jenis_quiz_id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String saran;
    public Quiz(int id , Integer jenis_quiz_id,String question, String option1, String option2, String option3, String option4, String option5, String saran){
        this.id = id;
        this.jenis_quiz_id = jenis_quiz_id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.saran = saran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getJenis_quiz_id() {
        return jenis_quiz_id;
    }

    public void setJenis_quiz_id(Integer jenis_quiz_id) {
        this.jenis_quiz_id = jenis_quiz_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }
}


