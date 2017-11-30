package ped.bstu.by.educationui.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import ped.bstu.by.educationui.R;
import ped.bstu.by.educationui.Student.Student;

public class AddTypeStudentActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    Student student;

    Button btnNext;
    RadioGroup radioGroup;
    RadioButton rbStudent, rbListener;

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_student);
        initialViews();
        student = getIntent().getParcelableExtra("Student");
    }

    private void initialViews() {
        radioGroup = findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);
        rbStudent = findViewById(R.id.rbStudent);
        rbListener = findViewById(R.id.rbListener);
        btnNext = findViewById(R.id.btnAddTypeNext);
        btnNext.setOnClickListener(this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        // something you want
        Student studentNew = (Student) getIntent().getParcelableExtra("Student");
        if(studentNew.getFirstName().equals("")) {        }
        else student = getIntent().getParcelableExtra("Student");
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnAddTypeNext:
                if(type != null) {
                    intent = new Intent(this, FinallyAddActivity.class);
                    intent.putExtra("Student",
                            new Student(student.getFirstName(), student.getMiddleName(), student.getLastName(),
                                    student.getBirthday(), student.getAddress(), type));
                    startActivity(intent);
                } else {
                    Toasty.warning(this, "Необходимо сделать выбор!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbListener:
                type = rbListener.getText().toString();
                break;
            case R.id.rbStudent:
                type = rbStudent.getText().toString();
                break;
        }
    }
}
