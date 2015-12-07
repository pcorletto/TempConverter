package com.example.android.temperatureconverter.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.android.temperatureconverter.R;
import com.example.android.temperatureconverter.model.convertTemp;


public class MainActivity extends ActionBarActivity {

    private EditText mInputTempEditText;
    private String mInputString;
    private float mInputTemp;
    private String mInputChoice = "F";
    private String mConvChoice = "C";
    private Button mConvertButton, mResetButton;
    private float mConvertedTemp;
    private RadioButton mFRadioButton;
    private convertTemp convertDegrees = new convertTemp();

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch(view.getId()){
            case R.id.fRadioButton:
                if(checked)
                    // Set mInputChoice to F. Call convertToCelsius();

                mInputChoice = "F";
                mConvChoice = "C";

                break;
            case R.id.cRadioButton:
                if(checked)
                    // Set mInputChoice to C. Call convertToFahrenheit();
                mInputChoice = "C";
                mConvChoice = "F";

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConvertButton = (Button) findViewById(R.id.returnToMainButton);
        mResetButton = (Button) findViewById(R.id.resetButton);
        mInputTempEditText = (EditText) findViewById(R.id.inputEditText);
        mFRadioButton = (RadioButton) findViewById(R.id.fRadioButton);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mInputString = mInputTempEditText.getText().toString();

                if(TextUtils.isEmpty(mInputString)){
                    mInputTempEditText.setError("You need to enter a temperature");
                    return;
                }

                mInputTemp = Float.parseFloat(mInputString);

                if(mInputChoice=="F"){
                    mConvertedTemp = convertDegrees.convertToCelsius(mInputTemp);
                }
                else if(mInputChoice=="C"){
                    mConvertedTemp = convertDegrees.convertToFahrenheit(mInputTemp);
                }

                displayConversion();

                //Toast.makeText(MainActivity.this, "The converted temperature is  " +
                //        mConvertedTemp + " degrees " + mConvChoice, Toast.LENGTH_LONG).show();
                    }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetUI();
            }
        });
    }

    public void displayConversion(){

        Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
        intent.putExtra(getString(R.string.input_temp), mInputTemp);
        intent.putExtra(getString(R.string.input_choice), mInputChoice);
        intent.putExtra(getString(R.string.conv_temp), mConvertedTemp);
        intent.putExtra(getString(R.string.conv_choice), mConvChoice);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();

    }

    public void resetUI(){
        mInputTempEditText.setText("");
        mFRadioButton.setChecked(true);
        mInputTemp=0;
        mConvertedTemp=0;
        mInputChoice="F";
        mConvChoice="C";
    }
}
