package ped.bstu.by.educationui.Activities;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ped.bstu.by.educationui.FileHelper.FileHelper;
import ped.bstu.by.educationui.MainActivity;
import ped.bstu.by.educationui.R;
import ped.bstu.by.educationui.Student.Student;

public class FinallyAddActivity extends AppCompatActivity implements View.OnClickListener {

    Student student;

    TextView tvFirstName, tvMiddleName, tvLastName, tvBirthday, tvAddress, tvType;
    Button btnNext;

    private final static String FILENAME = "students.json";
    private File FILEDIR;

    Gson gson = new Gson();
    Type itemsListType = new TypeToken<ArrayList<Student>>() {}.getType();

    ArrayList<Student> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finally_add);
        student = getIntent().getParcelableExtra("Student");
        initialViews();
        FILEDIR = Environment.getExternalStorageDirectory();
        String data = FileHelper.ReadJSON(FILEDIR, FILENAME);
        if(!data.equals("")) {
            arrayList = gson.fromJson(data, itemsListType);
        } else {
            arrayList = new ArrayList<>();
        }
        Log.d("MainAct(STUDENT)", student.toString());
    }

    private void initialViews() {
        btnNext = findViewById(R.id.btnFinallyNext);
        btnNext.setOnClickListener(this);
        tvFirstName = findViewById(R.id.tvFirstName);
        tvFirstName.setText(student.getFirstName());
        tvMiddleName = findViewById(R.id.tvMiddleName);
        tvMiddleName.setText(student.getMiddleName());
        tvLastName = findViewById(R.id.tvLastName);
        tvLastName.setText(student.getLastName());
        tvBirthday = findViewById(R.id.tvBirthday);
        tvBirthday.setText(student.getBirthday());
        tvAddress = findViewById(R.id.tvAddress);
        tvAddress.setText(student.getAddress());
        tvType = findViewById(R.id.tvType);
        tvType.setText(student.getType());
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
        switch (v.getId()) {
            case R.id.btnFinallyNext:
                arrayList.add(student);
                FileHelper.WriteJSON(FILEDIR, FILENAME, arrayList);
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
