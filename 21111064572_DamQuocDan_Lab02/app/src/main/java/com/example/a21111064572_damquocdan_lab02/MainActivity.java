package com.example.a21111064572_damquocdan_lab02;


        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView hienThiTextView;
    private EditText nameEditText;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private CheckBox amNhacCheckBox;
    private CheckBox duLichCheckBox;
    private CheckBox theThaoCheckBox;
    private Button luuDuLieuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hienThiTextView = findViewById(R.id.hienThiTextView);
        nameEditText = findViewById(R.id.Inputname);
        maleRadioButton = findViewById(R.id.genderNam);
        femaleRadioButton = findViewById(R.id.genderNu);
        amNhacCheckBox = findViewById(R.id.fvAmNhac);
        duLichCheckBox = findViewById(R.id.fvDuLich);
        theThaoCheckBox = findViewById(R.id.fvTheThao);
        luuDuLieuButton = findViewById(R.id.button);

        // Thêm sự kiện nghe cho nút luuDuLieuButton
        luuDuLieuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Lấy dữ liệu từ các Widget
                String name = nameEditText.getText().toString();
                String gender = maleRadioButton.isChecked() ? "Nam" : "Nữ";
                String hobbies = getHobbiesString();

                // Hiển thị dữ liệu trong hienThiTextView
                String displayText = "Tên: " + name + "\nGiới tính: " + gender + "\nSở thích: " + hobbies;
                hienThiTextView.setText(displayText);
            }
        });
    }

    // Xử lý Mục sở thích trả về nhiều giá trị
    private String getHobbiesString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (amNhacCheckBox.isChecked()) {
            stringBuilder.append("Âm nhạc ");
        }
        if (duLichCheckBox.isChecked()) {
            stringBuilder.append("Du lịch ");
        }
        if (theThaoCheckBox.isChecked()) {
            stringBuilder.append("Thể thao ");
        }
        return stringBuilder.toString().trim();
    }
}