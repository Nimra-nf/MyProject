package com.example.youmatter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button food;
    Button recipe;
    Button exercise;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitems, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                    OpenLogin();
                return true;
            case R.id.item2:
                //  Contact
                return true;
            case R.id.item3:
                // About
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase db = new AppDataBase(this);
        db.insertUser("Nimra", "nimra123");

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

    public void OpenLogin(){
        Intent intent1 = new Intent(this, Login.class);
        startActivity(intent1);
    }
}