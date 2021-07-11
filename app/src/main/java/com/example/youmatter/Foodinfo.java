package com.example.youmatter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Foodinfo extends AppCompatActivity {

    ImageView photo;
    TextView information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddetail);

        photo = (ImageView) findViewById(R.id.image);
        information = (TextView) findViewById(R.id.Information);
        Bundle bundle = getIntent().getExtras();
    }
}
