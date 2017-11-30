package ped.bstu.by.calories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import ped.bstu.by.calories.FieldsValidation.EmptyValidator;
import ped.bstu.by.calories.FieldsValidation.ValidatorsComposer;
import ped.bstu.by.calories.calories.Calories;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText editTextWeight;
    private EditText editTextHeight;
    private EditText editTextYears;
    private Spinner spinnerActivityLevel;
    private TextView results;

    private Integer weight, height, years;
    private Double calories;
    private String sex, activityLevel;

    final ValidatorsComposer<String> weightValidatorsComposer = new ValidatorsComposer<>(new EmptyValidator());
    final ValidatorsComposer<String> heightValidatorsComposer = new ValidatorsComposer<>(new EmptyValidator());
    final ValidatorsComposer<String> ageValidatorsComposer = new ValidatorsComposer<>(new EmptyValidator());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        editTextYears = (EditText)findViewById(R.id.editTextYears);
        spinnerActivityLevel = (Spinner)findViewById(R.id.spinner);
        results = (TextView)findViewById(R.id.textViewResults);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void onClickPrintResults(View v) {
        sex = getSex();

        activityLevel = spinnerActivityLevel.getSelectedItem().toString();

        checkOnValid();

        if(sex != null && weight != null & height != null && years != null) {
            calories = Calories.caclCalories(sex, weight, height, years, activityLevel);
            results.setText(calories.toString());
        }
    }

    private void checkOnValid() {
        if(!weightValidatorsComposer.isValid(editTextWeight.getText().toString()))
            Toasty.error(this, weightValidatorsComposer.getDescription(), Toast.LENGTH_SHORT).show();
        else weight = Integer.parseInt(editTextWeight.getText().toString());

        if(!heightValidatorsComposer.isValid(editTextHeight.getText().toString()))
            Toasty.error(this, heightValidatorsComposer.getDescription(), Toast.LENGTH_SHORT).show();
        else height = Integer.parseInt(editTextHeight.getText().toString());

        if(!ageValidatorsComposer.isValid(editTextYears.getText().toString()))
            Toasty.error(this, ageValidatorsComposer.getDescription(), Toast.LENGTH_SHORT).show();
        else years = Integer.parseInt(editTextYears.getText().toString());
    }

    public String getSex() {
        RadioButton rb = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        String sex = null;
        if(rb != null) {
            sex = rb.getText().toString();
        } else {
            Toasty.error(MainActivity.this, "Выберете ваш пол!", Toast.LENGTH_SHORT).show();
        }
        return sex;
    }

}