package com.example.a21111064572_damquocdan_lab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        Button buttonSecond = findViewById(R.id.buttonSecond);
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.thí, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
