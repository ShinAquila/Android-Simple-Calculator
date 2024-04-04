package com.example.simplecalcu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input_output;
    private TextView temp;

    private double num1;
    private double num2;
    private int operatorIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_output = findViewById(R.id.input_output);
        input_output.setShowSoftInputOnFocus(false);
        input_output.setFocusable(false);

        temp = findViewById(R.id.tempNums);
        temp.setShowSoftInputOnFocus(false);
        temp.setFocusable(false);
    }

    public void update_text(String toAdd){
        String previous = input_output.getText().toString();

        input_output.setText(previous.concat(toAdd));
        input_output.setSelection(input_output.getText().length());

    }

    public void operatorUpdate_text(String ope){
        String input = input_output.getText().toString();
        if(input.contains(".")){
            num1 = (int) Double.parseDouble(input);
        }else{
            num1 = Integer.parseInt(input);
        }

        temp.setText(input.concat(ope));

    }

    public void zeroBTN(View v){
        update_text("0");
    }
    public void oneBTN(View v){
        update_text("1");
    }
    public void twoBTN(View v){
        update_text("2");
    }
    public void threeBTN(View v){
        update_text("3");
    }
    public void fourBTN(View v){
        update_text("4");
    }
    public void fiveBTN(View v){
        update_text("5");
    }
    public void sixBTN(View v){
        update_text("6");
    }
    public void sevenBTN(View v){
        update_text("7");
    }
    public void eightBTN(View v){
        update_text("8");
    }
    public void nineBTN(View v){
        update_text("9");
    }

    public void dotBTN(View v){
        update_text(".");
    }


    public void addBTN(View v){
        operatorUpdate_text("+");
        String tempNum = input_output.getText().toString();
        if(tempNum.contains(".")){
            num1 = Double.parseDouble(tempNum);
        }else{
            num1 = Integer.parseInt(tempNum);
        }

        input_output.setText("");
        operatorIndicator = 1;
    }
    public void subtractBTN(View v){
        operatorUpdate_text("-");
        String tempNum = input_output.getText().toString();
        if(tempNum.contains(".")){
            num1 = Double.parseDouble(tempNum);
        }else{
            num1 = Integer.parseInt(tempNum);
        }
        input_output.setText("");
        operatorIndicator = 2;
    }
    public void multiplyBTN(View v){
        operatorUpdate_text("x");
        String tempNum = input_output.getText().toString();
        if(tempNum.contains(".")){
            num1 = Double.parseDouble(tempNum);
        }else{
            num1 = Integer.parseInt(tempNum);
        }
        input_output.setText("");
        operatorIndicator = 3;
    }
    public void divideBTN(View v){
        operatorUpdate_text("÷");
        String tempNum = input_output.getText().toString();
        if(tempNum.contains(".")){
            num1 = Double.parseDouble(tempNum);
        }else{
            num1 = Integer.parseInt(tempNum);
        }
        input_output.setText("");
        operatorIndicator = 4;
    }

    public void totalBTN(View v){
        String input = input_output.getText().toString();
        String num1temps = String.valueOf(num1);
        num2 = Integer.parseInt(input);

        String operator = null;
        double result = 0;

        if (operatorIndicator==1){
            result = (num1 + num2);
            operator = "+";
        } else if (operatorIndicator==2){
            result = (num1 - num2);
            operator = "-";
        } else if (operatorIndicator==3){
            result = (num1 * num2);
            operator = "*";
        } else if (operatorIndicator==4){
            result = (num1 / num2);
            operator = "/";
        }

        input_output.setText(String.valueOf(result));

        num1temps = num1temps.concat(operator);

        temp.setText(num1temps.concat(input));
    }

    public void clear_entry(View v){
        input_output.setText("");
        temp.setText("");
    }

    public void backspaceBTN(View v){
        String word = input_output.getText().toString();
        int input = word.length();
        if (input > 0) {
            input_output.setText(word.substring(0, input - 1));
        }
    }

}