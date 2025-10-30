package com.exam.brnquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    int correct, userAns;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        TextView questionTextView = view.findViewById(R.id.question);
//        Button submitButton = view.findViewById(R.id.submitButton);
//        ListView answersList = view.findViewById(R.id.answersList);
//
//        ArrayList<String> ans1 = new ArrayList<String>();
//        ans1.add("Medellin");
//        ans1.add("Madrid");
//        ans1.add("Paris");
//        ans1.add("Begota");
//
//        Question q1 = new Question("What is the capital of Colombia", ans1, 3);
//
//        questionTextView.setText(q1.question);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, q1.answerChoices);
//        answersList.setAdapter(adapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView questionTextView = view.findViewById(R.id.question);
        Button submitButton = view.findViewById(R.id.submitButton);
        ListView answersList = view.findViewById(R.id.answersList);

        BRNViewModel viewModel = new ViewModelProvider(this).get(BRNViewModel.class);



        ArrayList<String> ans1 = new ArrayList<String>();
        ans1.add("Medellin");
        ans1.add("Madrid");
        ans1.add("Paris");
        ans1.add("Begota");

        final Question[] q1 = {new Question("What is the capital of Colombia", ans1, 3)};
        questionTextView.setText(q1[0].question);
        correct = q1[0].correctAnswer;

        answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userAns = i;
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, q1[0].answerChoices);
        answersList.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               // Toast.makeText(getActivity(), userAns + "", Toast.LENGTH_SHORT).show();
                if(userAns == correct){
                    Toast.makeText(getActivity(), "Yay! +1 Point", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Wrong! User your BRN(AI)", Toast.LENGTH_SHORT).show();
                }

            }
        });

        viewModel.getQuestion().observe(getViewLifecycleOwner(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
            q1[0] = question;
                questionTextView.setText(q1[0].question);
                correct = q1[0].correctAnswer;
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }
}