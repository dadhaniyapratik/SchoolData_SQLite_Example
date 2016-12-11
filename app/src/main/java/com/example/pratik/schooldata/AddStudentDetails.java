package com.example.pratik.schooldata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.pratik.schooldata.Model.StudentData;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudentDetails extends AppCompatActivity {

    @Bind(R.id.edt_fname)
    EditText edtFname;
    @Bind(R.id.edt_lname)
    EditText edtLname;
    @Bind(R.id.edt_std)
    EditText edtStd;
    @Bind(R.id.edt_div)
    EditText edtDiv;
    @Bind(R.id.edt_result)
    EditText edtResult;
    @Bind(R.id.edt_percent)
    EditText edtPercent;
    @Bind(R.id.btn_save)
    Button btnSave;


    int i,i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_details);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        if(intent != null){
//            StudentData studentData = intent.getParcelableExtra("studentdata1");
//            edtFname.setText(studentData.getFname());
//            edtLname.setText(studentData.getLname());
//            edtStd.setText(studentData.getStd());
//            edtDiv.setText(studentData.getDiv());
//            edtResult.setText(studentData.getResult());
//            edtPercent.setText(studentData.getPercent());
//            i = intent.getIntExtra("position", 0);

            String fname = intent.getStringExtra("fname");
            String lname = intent.getStringExtra("lname");
            String div = intent.getStringExtra("div");
            String std = intent.getStringExtra("std");
            String percent = intent.getStringExtra("percent");
            String result = intent.getStringExtra("result");
            i = intent.getIntExtra("id", 0);
            i1 = intent.getIntExtra("position", 0);
            edtFname.setText(fname);
            edtLname.setText(lname);
            edtStd.setText(std);
            edtDiv.setText(div);
            edtResult.setText(result);
            edtPercent.setText(percent);
        }

    }

    @OnClick(R.id.btn_save)
    public void onClick() {
        StudentData studentData = new StudentData();
        studentData.setFname(edtFname.getText().toString());
        studentData.setLname(edtLname.getText().toString());
        studentData.setStd(edtStd.getText().toString());
        studentData.setDiv(edtDiv.getText().toString());
        studentData.setResult(edtResult.getText().toString());
        studentData.setPercent(edtPercent.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("studentdata",studentData);
        intent.putExtra("position",i);
        setResult(RESULT_OK,intent);
        finish();

    }
}
