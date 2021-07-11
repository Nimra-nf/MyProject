package com.example.youmatter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    Button nfood, nrecipe, nexercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);

        nfood = (Button) findViewById(R.id.NewFood);
        nrecipe = (Button) findViewById(R.id.NewRecipe);
        nexercise = (Button) findViewById(R.id.NewExercise);

        nfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenNewFood();
            }
        });
    }

    public void OpenNewFood(){
        Intent intent = new Intent(this, NewFood.class);
        startActivity(intent);
    }
}
