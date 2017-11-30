package ped.bstu.by.educationui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ped.bstu.by.educationui.Activities.AddNameActivity;
import ped.bstu.by.educationui.FileHelper.FileHelper;
import ped.bstu.by.educationui.Student.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String FILENAME = "students.json";
    private static final String TAG_ONCREATE = "MainActivity(onCreate)";
    private File FILEDIR;

    Gson gson = new Gson();
    Type itemsListType = new TypeToken<ArrayList<Student>>() {}.getType();

    TextView tvTextJSON;
    Button btnShow, btnAdd;

    ArrayList<Student> arrayList;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialViews();
        FILEDIR = Environment.getExternalStorageDirectory();

        if(!FileHelper.FileExist(FILEDIR, FILENAME)) {
            File f = new File(FILEDIR, FILENAME);
            try {
                f.createNewFile();
                Log.d(TAG_ONCREATE, "Файл " + FILENAME + " создан");
            } catch (IOException e) {
                Log.d(TAG_ONCREATE, "Файл " + FILENAME + " не создан ошибка: " + e.getMessage());
            }
        } else {
            String data = FileHelper.ReadJSON(FILEDIR, FILENAME);
            if(!data.equals("")) {
                arrayList = gson.fromJson(data, itemsListType);
            } else {
                arrayList = new ArrayList<>();
            }
        }
    }

    private void initialViews() {
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        tvTextJSON = findViewById(R.id.tvTextJSON);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShow:
                StringBuilder sb = new StringBuilder();
                for (Student item: arrayList) {
                    sb.append(item.toString() + "\r\n");
                }
                Log.d("SB", sb.toString());
                tvTextJSON.setText(String.valueOf(sb));
                break;
            case R.id.btnAdd:
                Intent intent = new Intent(this, AddNameActivity.class);
                startActivity(intent);
                break;
        }
    }

}
