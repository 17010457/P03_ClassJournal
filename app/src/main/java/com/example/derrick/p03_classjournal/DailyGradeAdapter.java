package com.example.derrick.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyGradeAdapter extends ArrayAdapter<DailyGrade> {

    private ArrayList<DailyGrade> grade;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;

    public DailyGradeAdapter(Context context, int resource, ArrayList<DailyGrade> objects) {
        super(context, resource, objects);
        grade = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_dailygrade, parent, false);

        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvGrade = rowView.findViewById(R.id.tvGrade);

        DailyGrade currentGrade = grade.get(position);

        tvWeek.setText("Week " + currentGrade.getWeekValue());
        tvGrade.setText(currentGrade.getGrade());
        return rowView;
    }
}
