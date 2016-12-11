package com.example.pratik.schooldata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.pratik.schooldata.Adapter.CustomListAdapter;
import com.example.pratik.schooldata.Database.DatabaseHandler;
import com.example.pratik.schooldata.Model.StudentData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.list_view)
    ListView listView;
    @Bind(R.id.btn_add)
    Button btnAdd;
    @Bind(R.id.btn_div)
    Button btnDiv;
    @Bind(R.id.btn_rsult)
    Button btnRsult;
    @Bind(R.id.btn_percent)
    Button btnPercent;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    Intent intent;
    StudentData studentData;
    CustomListAdapter customListAdapter;
    DatabaseHandler databaseHandler;
    List<StudentData> studentDatas;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        databaseHandler = new DatabaseHandler(MainActivity.this);
        studentDatas = databaseHandler.getAllContacts();
        customListAdapter = new CustomListAdapter(MainActivity.this, (List<StudentData>) studentDatas);
        listView.setAdapter(customListAdapter);

        customListAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.btn_add, R.id.btn_div, R.id.btn_rsult, R.id.btn_percent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                intent = new Intent(MainActivity.this,AddStudentDetails.class);
                startActivityForResult(intent,11);
                break;
            case R.id.btn_div:
                intent = new Intent(MainActivity.this,DivActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_rsult:
                intent = new Intent(MainActivity.this,ResultActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_percent:
                intent = new Intent(MainActivity.this,PercentActivity.class);
                startActivity(intent);
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==11)
        {
            if(resultCode==RESULT_OK) {

                studentData = data.getParcelableExtra("studentdata");
                databaseHandler.addContact(studentData);
                studentDatas = databaseHandler.getAllContacts();
                customListAdapter = new CustomListAdapter(MainActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();


            }
        }
        if(requestCode==111)
        {
            if(resultCode==RESULT_OK) {

                studentData = data.getParcelableExtra("studentdata");
                i = data.getIntExtra("position",0);
                databaseHandler.updateContact(studentData,i);
                studentDatas = databaseHandler.getAllContacts();
                customListAdapter = new CustomListAdapter(MainActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();

            }
        }
    }
}
