package com.example.youmatter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText u_name, pass;
    Button btn;
    AppDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        u_name = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(u_name.getText().toString(), pass.getText().toString());
            }
        });
    }

    public void check(String name, String passwoed){
        Cursor cs = db.CheckAdmin(name);
        if(cs.getCount()==0){
            Toast.makeText(this, "Incorrect Username!", Toast.LENGTH_SHORT).show();
        }
        else if(cs.getString(2) == passwoed){
            Toast.makeText(this, "Successfully Login!", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, Admin.class);
            startActivity(in);
        }
        else {
            Toast.makeText(this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
        }
    }
}
