package ped.bstu.by.educationui.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import ped.bstu.by.educationui.Activities.AddBirthdayActivity;
import ped.bstu.by.educationui.MainActivity;
import ped.bstu.by.educationui.R;
import ped.bstu.by.educationui.Student.Student;

public class AddNameActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFirstName, etMiddleName, etLastName;
    Button btnNext;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        initialViews();
        student = (Student) getIntent().getParcelableExtra("Student");
    }

    private void initialViews() {
        etFirstName = findViewById(R.id.editTextFirstName);
        etMiddleName = findViewById(R.id.editTextMiddleName);
        etLastName = findViewById(R.id.editTextLastName);
        btnNext = findViewById(R.id.btnAddNameNext);
        btnNext.setOnClickListener(this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        // something you want
        Student studentNew = (Student) getIntent().getParcelableExtra("Student");
        if(studentNew.getFirstName().equals("")){        }
        else student = (Student) getIntent().getParcelableExtra("Student");
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.btnAddNameNext:
                String FirstName = etFirstName.getText().toString();
                String MiddleName = etMiddleName.getText().toString();
                String LastName = etLastName.getText().toString();
                if (FirstName.equals("") || MiddleName.equals("") || LastName.equals("")) {
                    Toasty.warning(getApplicationContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(this, AddBirthdayActivity.class);
                    Student student = new Student(FirstName, MiddleName, LastName, "", "", "");
                    intent.putExtra("Student", student);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }
                break;
        }
    }
}
