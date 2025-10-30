package com.exam.brnquiz;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.ArrayList;

public class Question {
    public String question;
    public ArrayList<String> answerChoices;
    public int correctAnswer;

    public Question(String q, ArrayList<String> a, int c){
        this.question = q;
        this.answerChoices = a;
        this.correctAnswer = c;
    }

    public void observe(LifecycleOwner viewLifecycleOwner, Observer<Question> observer) {
        observer.onChanged(this);
    }
}
