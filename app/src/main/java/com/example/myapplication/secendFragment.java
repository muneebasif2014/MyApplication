package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link secendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class secendFragment extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_secend, container, false);

        textView=(TextView)view.findViewById(R.id.textfrag);

        return view;

    }

    public void setmethod(String textstr){
    textView.setText(textstr);
    }
}