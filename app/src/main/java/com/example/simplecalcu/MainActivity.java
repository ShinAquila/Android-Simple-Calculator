package com.example.simplecalcu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void num_input(View v){
        Button num1 = (Button) findViewById(R.id.num1BTN);

        EditText input_output = (EditText)findViewById(R.id.input_output);
        TextView tempNums = (TextView) findViewById(R.id.tempNums);

        int num = Integer.parseInt(num1.getText().toString());

        input_output.setText(""+num);
    }
}