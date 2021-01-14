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


public class LemsFragment extends Fragment {

    EditText editText;
    EditText editText1;
    TextView textVie;

    public static LemsFragment newInstance() {
        return new LemsFragment();
    }

    public LemsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_lems, container, false);
        Button bb = view.findViewById(R.id.button2);
        editText = view.findViewById(R.id.editTextTextPersonName3);
        editText1 = view.findViewById(R.id.editTextTextPersonName4);
        textVie = view.findViewById(R.id.textView5);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = /*getString(R.string.result_ssum) + */ editText.getText().toString() + " " + editText1.getText().toString();
                textVie.setText(message);
                Toast toast = Toast.makeText(getActivity(),editText.getText().toString() + " " + editText1.getText().toString(),Toast.LENGTH_SHORT);
                toast.show();
                addHistoryItem(editText.getText().toString(),editText1.getText().toString(),textVie.getText().toString());
            }
        });

        return view;
    }
    /*public void doMath(View view){
        EditText editText = (EditText) view.findViewById(R.id.editTextTextPersonName3);
        EditText editText1 = (EditText) view.findViewById(R.id.editTextTextPersonName4);
        String message = getString(R.string.result_ssum) + editText.getText().toString() + " " + editText1.getText().toString();
        TextView textVie = (TextView) view.findViewById(R.id.textView5);
        textVie.setText(message);
        Toast toast = Toast.makeText(getActivity(),editText.getText().toString() + " " + editText1.getText().toString(),Toast.LENGTH_SHORT);
        toast.show();
    }*/
    private void addHistoryItem(String firstThing, String secondThing, String resultThing){
        MainActivity parent = (MainActivity)getActivity();
        parent.addToList(new ListItemH(firstThing, secondThing, resultThing));
    }
}