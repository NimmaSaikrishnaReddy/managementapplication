package com.example.managementapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText regNoInput, nameInput, branchInput, marksInput,rollToFetchInput;
    Button buttonSave, buttonfetchedData;
     TextView studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler db = new DatabaseHandler(this);

        regNoInput = findViewById(R.id.regNoInput);
        nameInput = findViewById(R.id.nameInput);
        branchInput = findViewById(R.id.BranchInput);
        marksInput = findViewById(R.id.marksInput);
        rollToFetchInput = findViewById(R.id.fetchRegNoInput);
        buttonSave = findViewById(R.id.buttonSave);
        buttonfetchedData = findViewById(R.id.buttonFetch);
        studentInfo = findViewById(R.id.studentInfo);



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addStudent(
                        new Student(regNoInput.getText().toString(),
                                nameInput.getText().toString(),
                                branchInput.getText().toString(),
                                Integer.parseInt(marksInput.getText().toString())
                        )
                );


            }
        });

        buttonfetchedData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = db.getStudent(rollToFetchInput.getText().toString());

               studentInfo.setText(
                       "Reg No: " + student.regNo + "\n" +
                               "Name: " + student.name + "\n" +
                               "Branch: " + student.branch + "\n" +
                               "Marks: " + student.marks);
            }
        });
    }
}


