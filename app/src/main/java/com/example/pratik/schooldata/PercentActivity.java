package com.example.pratik.schooldata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.pratik.schooldata.Adapter.CustomListAdapter;
import com.example.pratik.schooldata.Database.DatabaseHandler;
import com.example.pratik.schooldata.Model.StudentData;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PercentActivity extends AppCompatActivity {

    @Bind(R.id.btn_per1)
    Button btnPer1;
    @Bind(R.id.list_view)
    ListView listView;

    List<StudentData> studentDatas;
    DatabaseHandler databaseHandler;
    CustomListAdapter customListAdapter;
    @Bind(R.id.btn_per2)
    Button btnPer2;
    @Bind(R.id.btn_per3)
    Button btnPer3;
    @Bind(R.id.btn_per4)
    Button btnPer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent);
        ButterKnife.bind(this);

        databaseHandler = new DatabaseHandler(PercentActivity.this);
    }

    @OnClick(R.id.btn_per1)
    public void onClick() {

        studentDatas = databaseHandler.getPercentOneContacts();
        customListAdapter = new CustomListAdapter(PercentActivity.this, studentDatas);
        listView.setAdapter(customListAdapter);
        customListAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.btn_per2, R.id.btn_per3, R.id.btn_per4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_per2:
                studentDatas = databaseHandler.getPercentTwoContacts();
                customListAdapter = new CustomListAdapter(PercentActivity.this, studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_per3:
                studentDatas = databaseHandler.getPercentThreeContacts();
                customListAdapter = new CustomListAdapter(PercentActivity.this, studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_per4:
                studentDatas = databaseHandler.getPercentFourContacts();
                customListAdapter = new CustomListAdapter(PercentActivity.this, studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
        }
    }
}
