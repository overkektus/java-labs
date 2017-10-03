package ped.bstu.by.bmr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import calories.calories;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickResults(View v) {
        int weight = Integer.parseInt(((EditText) findViewById(R.id.editTextWeight)).getText().toString());
        int height = Integer.parseInt(((EditText) findViewById(R.id.editTextHeight)).getText().toString());
        int age = Integer.parseInt(((EditText) findViewById(R.id.editTextAge)).getText().toString());

        
    }
}