package com.example.top101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String franchises[] = {
            "Los Angeles Lakers",
            "Boston Celtics",
            "Golden State Warriors",
            "Chicago Bulls",
            "San Antonio Spurs",
            "Philadelphia 76ers",
            "Detroit Pistons",
            "Miami Heat",
            "New York Knicks",
            "Houston Rockets"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, franchises));
        listView.setTextFilterEnabled(true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);

                intent.putExtra("franchises", position);

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }
}