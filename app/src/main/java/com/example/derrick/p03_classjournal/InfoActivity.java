package com.example.derrick.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    int requestCodeForAdd = 1;
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<DailyGrade> gradeArrList;
    Button btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent i = getIntent();
        final String module_code = i.getStringExtra("module_code");
        setTitle("Info for " + module_code);

        lv = findViewById(R.id.lvInfo);
        gradeArrList = new ArrayList<DailyGrade>();
        gradeArrList.add(new DailyGrade(1,"A"));
        gradeArrList.add(new DailyGrade(2,"A"));
        gradeArrList.add(new DailyGrade(3,"A"));

        adapter = new DailyGradeAdapter(this, R.layout.row_dailygrade, gradeArrList);
        lv.setAdapter(adapter);

        btnAdd = findViewById(R.id.btnAdd);
        btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String web = getString(R.string.rp_web);
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse(web + module_code));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"andy_tao@rp.edu.sg"});
                    String statement = "Hi faci,\n\nI am Derrick\nPlease see my remarks so far, thank you!\n\n";
                    for (int i =0; i<gradeArrList.size();i++){
                        statement += "Week " + gradeArrList.get(i).getWeekValue() + ": DG: " + gradeArrList.get(i).getGrade() +"\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, statement);
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email,"Choose an Email client : "));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddGradeActivity.class);
                int newWeek = gradeArrList.size()+1;
                i.putExtra("week", newWeek);
                startActivityForResult(i,requestCodeForAdd);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        // Only handle when 2nd activity close normally
        // and data contains something
        if (resultCode == RESULT_OK){
            if (data != null){
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                // If it is activity started by clicking
                // Superman, create corresponding String
                if (requestCode == requestCodeForAdd){
                    gradeArrList.add(new DailyGrade(gradeArrList.size()+1,grade));
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}
