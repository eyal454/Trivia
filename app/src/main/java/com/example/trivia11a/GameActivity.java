package com.example.trivia11a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btna1, btna2, btna3, btna4;

    private TextView tvQuestion;

    private TextView tvQuestionNumber, tvPoints, tvGameOver;

    private Collection collection;

    private Question q;
    private int points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvQuestion = findViewById(R.id.tvQuestion);
        btna1 = findViewById(R.id.btna1);
        btna2 = findViewById(R.id.btna2);
        btna3 = findViewById(R.id.btna3);
        btna4 = findViewById(R.id.btna4);

        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        tvGameOver = findViewById(R.id.tvGameOver);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvPoints = findViewById(R.id.tvPoints);

        tvGameOver.setVisibility(View.INVISIBLE);

        collection = new Collection();
        collection.initQuestions();

        nextQuestion();
    }

    private void nextQuestion() {
        if (collection.isNotLastQuestion())
        {
            q = collection.getNextQuestion();

            tvQuestion.setText(q.getQuestion());
            btna1.setText(q.getA1());
            btna2.setText(q.getA2());
            btna3.setText(q.getA3());
            btna4.setText(q.getA4());
        }

        else
        {
            tvGameOver.setVisibility(View.VISIBLE);
            createDialog();
        }

    }

    private void createDialog() {

    }

    @Override
    public void onClick(View v) {
        if (v == btna1)
        {
            if (q.getCorrect() == 1)
                points++;
        }

        if (v == btna2)
        {
            if (q.getCorrect() == 2)
                points++;
        }

        if (v == btna3)
        {
            if (q.getCorrect() == 3)
                points++;
        }

        if (v == btna4)
        {
            if (q.getCorrect() == 4)
                points++;
        }

        tvPoints.setText("points: " + points);
        if (collection.isNotLastQuestion())
        {
            tvQuestionNumber.setText("Question number: " + (collection.getIndex() + 1 ));
        }

        nextQuestion();

    }
}