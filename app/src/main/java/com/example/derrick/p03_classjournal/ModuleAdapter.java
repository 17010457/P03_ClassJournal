package com.example.derrick.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> module;
    private Context context;
    private TextView tvCode;
    private TextView tvName;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects) {
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_module, parent, false);

        tvCode = rowView.findViewById(R.id.tvCode);
        tvName = rowView.findViewById(R.id.tvName);

        Module currentModule = module.get(position);

        tvCode.setText(currentModule.getCode());
        tvName.setText(currentModule.getName());
        return rowView;
    }
}
