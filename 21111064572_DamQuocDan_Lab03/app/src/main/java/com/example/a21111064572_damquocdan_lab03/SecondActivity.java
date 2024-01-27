package com.example.a21111064572_damquocdan_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText diemedit;
    TextView diemtv;
    Button thongbaobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        diemedit=findViewById(R.id.diemedit2);
        diemtv=findViewById(R.id.diemtv2);
        thongbaobtn=findViewById(R.id.thongbaoBtn2);
        Intent intent=getIntent();
        diemtv.setText(intent.getStringExtra("hoten"));
        thongbaobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diem=diemedit.getText().toString().trim();
                Intent intent1= new Intent();
                Bundle bundle= new Bundle();
                bundle.putString("diemgui",diem);
                intent1.putExtras(bundle);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }
}