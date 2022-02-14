package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class labtask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtask);
        // ListView list = findViewById(R.id.list);
        // ArrayList<String> abc = new ArrayList<>();
        // abc.add("Muneeb");
        // abc.add("Sami");
        // abc.add("talha");
        //
        // ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, abc);
        // list.setAdapter(adp);
    }
    private ArrayList<City> initCities() {
        ArrayList<City> list = new ArrayList<>();

        list.add(new City("Cinque Terre", "The coastline, the five villages in Italy.", "https://bit.ly/CBImageCinque"));
        list.add(new City("Paris", "Paris is the capital city of France", "https://bit.ly/CBImageParis"));
        list.add(new City("Rio de Janeiro", "Rio has been one of Brazil's most popular destinations.", "https://bit.ly/CBImageRio"));
        list.add(new City("Sydney", "Sydney is the state capital of New South Wales.", "https://bit.ly/CBImageSydney"));

        return list;
    }
}