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

public class DivActivity extends AppCompatActivity {

    @Bind(R.id.btn_div_a)
    Button btnDivA;
    @Bind(R.id.btn_div_b)
    Button btnDivB;
    @Bind(R.id.btn_div_c)
    Button btnDivC;
    @Bind(R.id.btn_div_d)
    Button btnDivD;
    @Bind(R.id.btn_div_e)
    Button btnDivE;
    @Bind(R.id.list_view)
    ListView listView;

    List<StudentData> studentDatas;
    DatabaseHandler databaseHandler;
    CustomListAdapter customListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.div_activity);
        ButterKnife.bind(this);

        databaseHandler = new DatabaseHandler(DivActivity.this);
    }

    @OnClick({R.id.btn_div_a, R.id.btn_div_b, R.id.btn_div_c, R.id.btn_div_d, R.id.btn_div_e})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_div_a:

                studentDatas = databaseHandler.getDivAContacts();
                customListAdapter = new CustomListAdapter(DivActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_div_b:
                studentDatas = databaseHandler.getDivBContacts();
                customListAdapter = new CustomListAdapter(DivActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_div_c:
                studentDatas = databaseHandler.getDivCContacts();
                customListAdapter = new CustomListAdapter(DivActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_div_d:
                studentDatas = databaseHandler.getDivDContacts();
                customListAdapter = new CustomListAdapter(DivActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_div_e:
                studentDatas = databaseHandler.getDivEContacts();
                customListAdapter = new CustomListAdapter(DivActivity.this,studentDatas);
                listView.setAdapter(customListAdapter);
                customListAdapter.notifyDataSetChanged();
                break;
        }
    }
}
