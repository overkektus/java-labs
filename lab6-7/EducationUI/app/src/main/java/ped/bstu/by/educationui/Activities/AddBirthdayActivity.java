package ped.bstu.by.educationui.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import es.dmoral.toasty.Toasty;
import ped.bstu.by.educationui.R;
import ped.bstu.by.educationui.Student.Student;

public class AddBirthdayActivity extends AppCompatActivity implements View.OnClickListener {

    Student student;

    Button btnPickDate, btnNext;
    TextView currentDateTime;
    EditText etAddAddress;

    Calendar dateAndTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_birthday);
        initialViews();
        setInitialDateTime();
        student = (Student) getIntent().getParcelableExtra("Student");
    }

    private void initialViews() {
        etAddAddress = findViewById(R.id.etAddAddress);
        currentDateTime = findViewById(R.id.currentDateTime);
        btnPickDate = findViewById(R.id.btnAddBirthdayPickDate);
        btnPickDate.setOnClickListener(this);
        btnNext = findViewById(R.id.btnAddBirthdayNext);
        btnNext.setOnClickListener(this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        // something you want
        Student studentNew = (Student) getIntent().getParcelableExtra("Student");
        if(studentNew.getFirstName().equals("")) {
            student = new Student();
        }
        else student = (Student) getIntent().getParcelableExtra("Student");
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()) {
            case R.id.btnAddBirthdayPickDate:
                new DatePickerDialog(AddBirthdayActivity.this, d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH))
                        .show();
                break;
            case R.id.btnAddBirthdayNext:
                String selectedDate = currentDateTime.getText().toString();
                String address = etAddAddress.getText().toString();
                if(!address.equals("")) {
                    address = etAddAddress.getText().toString();
                    intent = new Intent(this, AddTypeStudentActivity.class);
                    intent.putExtra("Student",
                            new Student(student.getFirstName(), student.getMiddleName(), student.getLastName(),
                                    selectedDate, address, ""));
                    startActivity(intent);
                } else {
                    address = etAddAddress.getText().toString();
                    Toasty.warning(this, "Введите адрес", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void setInitialDateTime() {
        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
}
