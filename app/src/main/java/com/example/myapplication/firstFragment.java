 package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


 public class firstFragment extends Fragment {
    View fragmentview;
    ListView list;
    String[] countryname = new String[]{"Pakistan","India","us"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentview = inflater.inflate(R.layout.fragment_first, container, false);

        list= fragmentview.findViewById(R.id.listfrag1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,countryname);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                secendFragment sec = (secendFragment)getFragmentManager().findFragmentById(R.id.fragment2);
                sec.setmethod("country"+countryname[position]);
            }
        });



      
        return fragmentview;


    }
}