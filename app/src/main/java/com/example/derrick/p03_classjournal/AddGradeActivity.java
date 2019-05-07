package com.example.derrick.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddGradeActivity extends AppCompatActivity {

    TextView tvAddWeek;
    RadioGroup rgGrade;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        Intent i = getIntent();

        tvAddWeek = findViewById(R.id.tvAddWeek);
        rgGrade = findViewById(R.id.rgGrade);
        btnSubmit = findViewById(R.id.btnSubmit);

        int week = i.getIntExtra("week",0);
        setTitle("Add data for Week " + week);
        tvAddWeek.setText("Week " + week);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedGrade = rgGrade.getCheckedRadioButtonId();
                RadioButton rbSelected = findViewById(selectedGrade);
                String selected = rbSelected.getText().toString();
                Intent i = new Intent();
                i.putExtra("grade",selected);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
