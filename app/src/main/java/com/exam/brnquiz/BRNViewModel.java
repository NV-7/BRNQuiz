package com.exam.brnquiz;

import androidx.lifecycle.ViewModel;

public class BRNViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    int numOfCorrect;
    Question question;

    public BRNViewModel(int numOfCorrect, Question question) {
        this.numOfCorrect = numOfCorrect;
        this.question = question;

    }

    public int getNumOfCorrect() {
        return numOfCorrect;
    }

    public Question getQuestion() {
        return question;

    }
}