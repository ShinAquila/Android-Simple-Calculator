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
    private String stringNum1;
    private String stringNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_output = (EditText) findViewById(R.id.input_output);
        input_output.setShowSoftInputOnFocus(false);
        input_output.setFocusable(false);
        stringNum1 = input_output.getText().toString();

        temp = findViewById(R.id.tempNums);
        temp.setShowSoftInputOnFocus(false);
        temp.setFocusable(false);
        stringNum2 = temp.getText().toString();
    }

    public void update_text(String toAdd){
        String previous = input_output.getText().toString();

        input_output.setText(previous.concat(toAdd));
        input_output.setSelection(input_output.getText().length());

    }

    public void operatorUpdate_text(String ope){
        String input = input_output.getText().toString();
        num1 = Double.parseDouble(input);

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
//        if ((!stringNum1.isEmpty())&& (!stringNum2.isEmpty())){
//            totalBTN(v);
//        } else {
//            input_output.setText("");
//        }

        input_output.setText("");
        operatorIndicator = 1;
    }
    public void subtractBTN(View v){
        operatorUpdate_text("-");

        input_output.setText("");
        operatorIndicator = 2;
    }
    public void multiplyBTN(View v){
        operatorUpdate_text("x");

        input_output.setText("");
        operatorIndicator = 3;
    }
    public void divideBTN(View v){
        operatorUpdate_text("÷");

        input_output.setText("");
        operatorIndicator = 4;
    }

//    public void percentBTN(View v){
//        operatorUpdate_text("%");
//
//        if (num1 != 0){
//
//        }
//
//        input_output.setText(String.valueOf(num1/100));
//    }

    public void totalBTN(View v){
        String num2String = input_output.getText().toString();
        String num1String = null;

        if ((int) num1 == num1){
            num1String = String.valueOf((int)num1);
        } else{
            num1String = String.valueOf(num1);
        }

        num2 = Double.parseDouble(num2String);

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

        if ((int) result == result){
            input_output.setText(String.valueOf((int)result));
        } else {
            input_output.setText(String.valueOf(result));
        }

        temp.setText(String.format("%s%s%s",num1String,operator,num2String));
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