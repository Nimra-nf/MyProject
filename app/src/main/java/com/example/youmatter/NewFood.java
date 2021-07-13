package com.example.youmatter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewFood extends AppCompatActivity {

    Button add;
    EditText name, image, calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newfood);

        name = (EditText) findViewById(R.id.fname);
        image = (EditText) findViewById(R.id.fimage);
        calories = (EditText) findViewById(R.id.calories);
        add = (Button) findViewById(R.id.Addf);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataBase db = new AppDataBase(NewFood.this);
                db.insertfood(name.getText().toString().trim(),
                        image.getText().toString().trim(),
                        Integer.parseInt(calories.getText().toString().trim()));
            }
        });
    }
}
