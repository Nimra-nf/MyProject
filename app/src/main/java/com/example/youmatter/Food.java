package com.example.youmatter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Food extends AppCompatActivity {

    ListView lv;
    AppDataBase db;
    ArrayList<String> imageid, name;

    public void myarrays() {

        db = new AppDataBase(this);
        imageid = new ArrayList<>();
        name = new ArrayList<>();

        Cursor cs = db.getData();
        while (cs.moveToNext()) {
            name.add(cs.getString(1));
            imageid.add(cs.getString(2));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodspage);

        Intent intent = getIntent();

        lv = (ListView) findViewById(R.id.foodlist);
        CustomAdapter Adapter = new CustomAdapter(Food.this, imageid, name);
        lv.setAdapter(Adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(Food.this, Foodinfo.class);
                mIntent.putExtra("countryName", imageid);
                mIntent.putExtra("countryFlag", name);
                startActivity(mIntent);
            }
        });
        }


    }
