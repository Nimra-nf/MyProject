package com.example.youmatter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button food;
    Button recipe;
    Button exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        food = (Button) findViewById(R.id.Food);
        recipe = (Button) findViewById(R.id.Recipes);
        exercise = (Button) findViewById(R.id.Exercises);

        food.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                OpenFood();
            }
        });

    }
    public void OpenFood(){
        Intent intent = new Intent(this, Food.class);
        startActivity(intent);
    }
}