package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerFrom;
    Spinner spinnerTo;
    Button actionButton;
    TextView sourceUnit;
    EditText inputVal;
    TextView desUnit;
    TextView convertedVal;
    String[] unitsFrom= {"Length-Inch","Length-Foot","Weight-Pound", "Weight-Ounce"};
    String[] unitsTo= {"Length-Inch","Length-Foot","Weight-Pound", "Weight-Ounce"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinner);
        spinnerTo = findViewById(R.id.spinner2);
        actionButton = findViewById(R.id.button);
        sourceUnit = findViewById(R.id.textViewS);
        inputVal = findViewById(R.id.inputVal);
        desUnit = findViewById(R.id.textViewDes);
        convertedVal = findViewById(R.id.textViewRes);

        ArrayAdapter uFrom = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,unitsFrom);
        spinnerFrom.setAdapter(uFrom);

        ArrayAdapter uTo = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,unitsTo);
        spinnerTo.setAdapter(uTo);


        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double inVal = Double.parseDouble(inputVal.getText().toString());
                Double cVal;

                try {
                    if(spinnerFrom.getSelectedItem().toString() == "Length-Inch" && spinnerTo.getSelectedItem().toString() == "Length-Foot" && inputVal.getText() != null){
                        cVal = inVal * 0.0833;
                        convertedVal.setText(inVal + "Inches in Foot is: "  + cVal);
                    } else if (inputVal.getText() == null) {
                        Toast.makeText(MainActivity.this, "Input Cannot be Empty", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "Input Valid", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                try {
                    if(spinnerFrom.getSelectedItem().toString() == "Weight-Pound" && spinnerTo.getSelectedItem().toString() == "Weight-Ounce" && inputVal.getText() != null){
                        cVal = inVal * 16;
                        convertedVal.setText(inVal + "Pound in Ounces is: "  + cVal);
                    } else if (inputVal.getText() == null) {
                        Toast.makeText(MainActivity.this, "Input Cannot be Empty", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "Input Valid", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}