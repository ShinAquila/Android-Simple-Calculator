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

    private int num1;
    private int num2;
    private int operatorIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_output = findViewById(R.id.input_output);
        input_output.setShowSoftInputOnFocus(false);

        temp = findViewById(R.id.tempNums);
        temp.setShowSoftInputOnFocus(false);

    }

    public void update_text(String toAdd){
        String previous = input_output.getText().toString();

        input_output.setText(previous.concat(toAdd));
        input_output.setSelection(input_output.getText().length());

    }

    public void operatorUpdate_text(String ope){
        String input = input_output.getText().toString();
        num1 = Integer.parseInt(input);

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


    public void addBTN(View v){
        operatorUpdate_text("+");
        num1 = Integer.parseInt(input_output.getText().toString());
        input_output.setText("");
        operatorIndicator = 1;
    }
    public void subtractBTN(View v){
        update_text("-");
        num1 = Integer.parseInt(input_output.getText().toString());
        input_output.setText("");
        operatorIndicator = 2;
    }
    public void multiplyBTN(View v){
        update_text("x");
        num1 = Integer.parseInt(input_output.getText().toString());
        input_output.setText("");
        operatorIndicator = 3;
    }
    public void divideBTN(View v){
        update_text("÷");
        num1 = Integer.parseInt(input_output.getText().toString());
        input_output.setText("");
        operatorIndicator = 4;
    }


    public void totalBTN(View v){
        String input = input_output.getText().toString();
        String temps = String.valueOf(num1);
        num2 = Integer.parseInt(input);

        String operator = null;

        int result = 0;

        if (operatorIndicator==1){
            result = num1 + num2;
            operator = "+";
        } else if (operatorIndicator==2){
            result = num1 - num2;
            operator = "-";
        } else if (operatorIndicator==3){
            result = num1 * num2;
            operator = "*";
        } else if (operatorIndicator==4){
            result = num1 / num2;
            operator = "/";
        }

        temps = temps.concat(operator);

        temp.setText(temps.concat(input));

        input_output.setText(String.valueOf(result));
    }

    public void clear_entry(View v){
        input_output.setText("");
        temp.setText("");
    }

}