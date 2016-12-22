package com.biggreenspaceship.gpacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner0, spinner1;
    ArrayAdapter<CharSequence> adapter0, adapter1;
    ArrayAdapter<String> listAdapter;
    ArrayList arrayList;
    ListView gradeList;
    EditText input0, input1;
    Button button0, button1, button2;
    int currentCredits, newGradeInt, newCreditsInt;
    int i = 0;
    double currentGPA;
    String newGrade, newCredits;
    String[] gradesArray = new String[] {"", "", "", "", "", ""};
    String[] creditsArray = new String[] {"", "", "", "", "", ""};
    int[] gradesIntArray = new int[] {0, 0, 0, 0, 0, 0};
    int[] creditsIntArray = new int[] {0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //current gpa input
        input0 = (EditText) findViewById(R.id.editText5);
        button0 = (Button) findViewById(R.id.gpa_button);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input0.getText().toString().matches("")) {
                    Toast.makeText(getBaseContext(), "Nothing", Toast.LENGTH_SHORT).show();
                } else {
                    currentGPA = Double.parseDouble(input0.getText().toString());
                }
            }
        });

        //current credit input
        input1 = (EditText) findViewById(R.id.editText6);
        button1 = (Button) findViewById(R.id.credit_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (input1.getText().toString().matches("")) {
                    Toast.makeText(getBaseContext(), "Nothing", Toast.LENGTH_SHORT).show();
                } else {
                    currentCredits = Integer.parseInt(input1.getText().toString());
                }
            }
        });

        //credit spinner
        spinner0 = (Spinner) findViewById(R.id.spinner5);
        adapter0 = ArrayAdapter.createFromResource(this,
                R.array.credits_spinner_array, android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner0.setAdapter(adapter0);
        spinner0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                newCredits = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //grade spinner
        spinner1 = (Spinner) findViewById(R.id.spinner6);
        adapter1 = ArrayAdapter.createFromResource(this,
                R.array.grade_spinner_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                newGrade = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button2 = (Button) findViewById(R.id.add_button);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                if ((newGrade.matches("Grade")) || (newCredits.matches("Credits"))) {
                    Toast.makeText(getBaseContext(), "Missing input", Toast.LENGTH_SHORT).show();
                } else {
                    gradesArray[i] = newGrade;
                    creditsArray[i] = newCredits;

                    switch (newGrade) {
                        case "A":
                            newGradeInt = 4;
                            break;
                        case "B":
                            newGradeInt = 3;
                            break;
                        case "C":
                            newGradeInt = 2;
                            break;
                        case "D":
                            newGradeInt = 1;
                            break;
                        default:
                            break;
                    }

                    gradesIntArray[i] = newGradeInt;
                    newCreditsInt = Integer.parseInt(newCredits);
                    creditsIntArray[i] = newCreditsInt;

                    gradeList = (ListView) findViewById(R.id.muhlist);
                    listAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, gradesArray);
                    gradeList.setAdapter(listAdapter);

                    gradeList = (ListView) findViewById(R.id.muhlist2);
                    listAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, creditsArray);
                    gradeList.setAdapter(listAdapter);
                    i = i + 1;
                }
            }
        });

        Button button3 = (Button) findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                double gpa = 0.0;
                for (int j : gradesIntArray) {
                    gpa =+ j;
                }

            }
        });

    }
}
