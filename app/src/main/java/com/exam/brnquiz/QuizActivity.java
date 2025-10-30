package com.exam.brnquiz;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        FragmentManager fm = getSupportFragmentManager();
        ScoreFragment sf = new ScoreFragment();
        QuestionFragment qf = new QuestionFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.scoreFrag, sf);
        ft.add(R.id.quizFrag, qf);
        ft.commit();




    }
}