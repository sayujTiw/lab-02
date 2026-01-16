package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button addCity;
    Button delCity;

    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        addCity = findViewById(R.id.city_button);
        delCity = findViewById(R.id.city_buttondel);
        input = findViewById(R.id.input);

        addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input.getText().toString();
                if (!name.isEmpty()) {
                    dataList.add(name);
                    cityAdapter.notifyDataSetChanged();
                    input.setText("");
                }
            }
        });

        delCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input.getText().toString();
                if (!name.isEmpty()) {
                    dataList.remove(name);
                    cityAdapter.notifyDataSetChanged();
                    input.setText("");
                }
            }
        });





    }
}