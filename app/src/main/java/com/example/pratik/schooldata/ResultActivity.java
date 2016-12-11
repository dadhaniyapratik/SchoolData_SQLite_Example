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

public class ResultActivity extends AppCompatActivity {

    @Bind(R.id.btn_pass)
    Button btnPass;
    @Bind(R.id.btn_fail)
    Button btnFail;
    @Bind(R.id.list_view)
    ListView listView;

    DatabaseHandler databaseHandler;
    CustomListAdapter customListAdapter;
    List<StudentData> studentDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        databaseHandler = new DatabaseHandler(ResultActivity.this);
    }

    @OnClick({R.id.btn_pass, R.id.btn_fail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pass:
                studentDataList = databaseHandler.getResultPassContacts();
                customListAdapter = new CustomListAdapter(ResultActivity.this,studentDataList);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_fail:
                studentDataList = databaseHandler.getResultFailContacts();
                customListAdapter = new CustomListAdapter(ResultActivity.this,studentDataList);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
        }
    }
}
