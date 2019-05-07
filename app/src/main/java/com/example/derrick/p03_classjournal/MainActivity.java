package com.example.derrick.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter adapter;
    ArrayList<Module> moduleArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModules);
        moduleArrayList = new ArrayList<Module>();
        moduleArrayList.add(new Module("C302","Web Services"));
        moduleArrayList.add(new Module("C347","Android Programming II"));

        adapter = new ModuleAdapter(this, R.layout.row_module, moduleArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = moduleArrayList.get(position);
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("module_code",selectedModule.getCode());
                startActivity(i);
            }
        });
    }
}
