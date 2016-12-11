package com.example.pratik.schooldata.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pratik.schooldata.AddStudentDetails;
import com.example.pratik.schooldata.Database.DatabaseHandler;
import com.example.pratik.schooldata.Model.StudentData;
import com.example.pratik.schooldata.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratik on 05-Nov-16.
 */

public class CustomListAdapter extends BaseAdapter {
    private Activity context; //context
    private List<StudentData> studentDatas; //data source of the list adapter
    CustomListAdapter customListAdapter;

    //public constructor
    public CustomListAdapter(Activity context, List<StudentData> studentDatas) {
        this.context = context;
        this.studentDatas = studentDatas;
    }

    @Override
    public int getCount() {
        return studentDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return studentDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView fname;
        TextView lname;
        TextView std;
        TextView div;
        TextView result;
        TextView percent;
        Button btn_update;
        Button btn_delete;
        ListView list_view;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_details_raw, parent, false);
            holder = new ViewHolder();
            holder.fname = (TextView)convertView.findViewById(R.id.tv_fname);
            holder.lname = (TextView) convertView.findViewById(R.id.tv_lname);
            holder.std = (TextView) convertView.findViewById(R.id.tv_std);
            holder.div = (TextView) convertView.findViewById(R.id.tv_div);
            holder.result = (TextView) convertView.findViewById(R.id.tv_result);
            holder.percent = (TextView) convertView.findViewById(R.id.tv_percent);
            holder.btn_update = (Button) convertView.findViewById(R.id.btn_update);
            holder.btn_delete = (Button) convertView.findViewById(R.id.btn_delete);
            holder.list_view = (ListView) convertView.findViewById(R.id.list_view);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final StudentData currentItem = (StudentData) getItem(position);
        holder.fname.setText(currentItem.getFname());
        holder.lname.setText(currentItem.getLname());
        holder.std.setText(currentItem.getStd());
        holder.div.setText(currentItem.getDiv());
        holder.result.setText(currentItem.getResult());
        holder.percent.setText(currentItem.getPercent());



        holder.btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, AddStudentDetails.class);
////                    String value = lv1.getAdapter().getItem(position).toString();
//                StudentData studentData = new StudentData();
//                studentData.setFname(holder.fname.getText().toString());
//                studentData.setLname(holder.lname.getText().toString());
//                studentData.setStd(holder.std.getText().toString());
//                studentData.setDiv(holder.div.getText().toString());
//                studentData.setResult(holder.result.getText().toString());
//                studentData.setPercent(holder.percent.getText().toString());
//                intent.putExtra("studentdata1",studentData);
//                int key_id = currentItem.get_id();
//                intent.putExtra("position",key_id);
//                context.startActivityForResult(intent,111);

                Intent intent = new Intent(context, AddStudentDetails.class);
                String fname = studentDatas.get(position).getFname();
                String lname = studentDatas.get(position).getLname();
                String div = studentDatas.get(position).getDiv();
                String std = studentDatas.get(position).getStd();
                String percent = studentDatas.get(position).getPercent();
                String result = studentDatas.get(position).getResult();
                int key_id = currentItem.get_id();

                intent.putExtra("fname", fname);
                intent.putExtra("lname", lname);
                intent.putExtra("div", div);
                intent.putExtra("std", std);
                intent.putExtra("percent", percent);
                intent.putExtra("result", result);
                intent.putExtra("id",key_id);
                intent.putExtra("position",position);
                context.startActivityForResult(intent,111);


            }
        });

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler databaseHandler = new DatabaseHandler(context);
                int i = currentItem.get_id();
                databaseHandler.deleteContact(i);
                customListAdapter = new CustomListAdapter(context,studentDatas);
                holder.list_view.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }

}
