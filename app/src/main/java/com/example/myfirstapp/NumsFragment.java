package com.example.myfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NumsFragment extends Fragment {
    EditText editText;
    EditText editText1;
    TextView textVie;
    public NumsFragment() {
        // Required empty public constructor
    }
    public static NumsFragment newInstance() {
        return new NumsFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_nums, container, false);
        Button bb = view.findViewById(R.id.button5);
        editText = view.findViewById(R.id.editTextNumber);
        editText1 = view.findViewById(R.id.editTextNumber2);
        textVie = view.findViewById(R.id.textView7);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer sum = Integer.parseInt(editText.getText().toString()) + Integer.parseInt(editText1.getText().toString());
                textVie.setText(String.valueOf(sum));
                Toast toast = Toast.makeText(getActivity(),String.valueOf(sum),Toast.LENGTH_SHORT);
                toast.show();
                addHistoryItem(editText.getText().toString(),editText1.getText().toString(),textVie.getText().toString());
            }
        });
        return view;
    }
    private void addHistoryItem(String firstThing, String secondThing, String resultThing){
        MainActivity parent = (MainActivity)getActivity();
        parent.addToList(new ListItemH(firstThing, secondThing, resultThing));
    }
}