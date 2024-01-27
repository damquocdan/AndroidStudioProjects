package com.example.a21111064572_damquocdan_lab03;

import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText hotendt;
    TextView diemdt;
    Button guibtn;

    // Declare the ActivityResultLauncher as a member variable
    private ActivityResultLauncher<Intent> nhandiemSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        hotendt = findViewById(R.id.hotendt);
        diemdt = findViewById(R.id.diemdt);
        guibtn = findViewById(R.id.guiBtn);

        guibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,SecondActivity.class);
                myintent.putExtra("hoten", hotendt.getText().toString().trim());

                // Start the activity using the launcher
                nhandiemSV.launch(myintent);
            }
        });

        // Initialize the ActivityResultLauncher
        nhandiemSV = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Check if the result is OK and handle it accordingly
                        if (result.getResultCode() == RESULT_OK) {

                            Intent data = result.getData();
                            if (data != null) {
                                Bundle bundle    = data.getExtras();
                                String diemData = data.getStringExtra("diemgui");
                                diemdt.setText(diemData);
                            }
                        }
                    }
                }
        );
    }
}