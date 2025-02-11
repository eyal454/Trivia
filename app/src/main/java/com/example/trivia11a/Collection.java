package com.example.trivia11a;

import java.util.ArrayList;

public class Collection {

    private ArrayList<Question> arr;
    private int index; //מספר השאלה ההבאה בתור

    public Collection()
    {
        Question q1 = new Question("1+10","7","11","3","100",2);
        Question q2 = new Question("1+2","8","2","3","100",2);
        Question q3 = new Question("1+3","6","8","4","100",3);
        Question q4 = new Question("1+4","5","7","2","100",1);
        Question q5 = new Question("1+0","1","4","5","100",1);

        arr = new ArrayList<>();
        arr.add(q1);
        arr.add(q2);
        arr.add(q3);
        arr.add(q4);
        arr.add(q5);


    }

    public void initQuestions()
    {
        index = 0;
    }

    public Question getNextQuestion()
    {
        Question q = arr.get(index);
        index++;
        return q;

    }

    public boolean isNotLastQuestion()
    {
        return(index<arr.size());
    }

    public int getIndex()
    {
        return index;
    }
}
