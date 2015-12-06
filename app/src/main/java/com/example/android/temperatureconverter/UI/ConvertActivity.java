package com.example.android.temperatureconverter.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.temperatureconverter.R;

public class ConvertActivity extends ActionBarActivity {

    private TextView mInputTemp, mInputChoice, mConvTemp, mConvChoice;
    private Button mReturnToMainButton;
    private String inputChoice, convChoice;
    private int inputTemp, convTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        mInputTemp = (TextView) findViewById(R.id.inputTempTextView);
        mInputChoice = (TextView) findViewById(R.id.inputChoiceTextView);
        mConvTemp = (TextView) findViewById(R.id.convTempTextView);
        mConvChoice = (TextView) findViewById(R.id.convChoiceTextView);
        mReturnToMainButton = (Button) findViewById(R.id.returnToMainButton);

        Intent intent = getIntent();
        inputTemp = intent.getIntExtra(getString(R.string.input_temp), 0);
        inputChoice = intent.getStringExtra(getString(R.string.input_choice));
        convTemp = intent.getIntExtra(getString(R.string.conv_temp), 0);
        convChoice = intent.getStringExtra(getString(R.string.conv_choice));

        mInputTemp.setText(inputTemp+"");
        mInputChoice.setText(inputChoice);
        mConvTemp.setText(convTemp+"");
        mConvChoice.setText(convChoice);

        mReturnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }





}
