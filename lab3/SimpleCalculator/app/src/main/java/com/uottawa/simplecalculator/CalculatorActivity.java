package com.uottawa.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {

    EditText resultEdit;
    private  double cValue;
    private  char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultEdit = (EditText)findViewById(R.id.resultEdit);
    }

    public void onClick00(View view)
    {
        populate("0");
    }

    public void onClick01(View view)
    {
        populate("1");
    }

    public void onClick02(View view)
    {
        populate("2");
    }

    public void onClick03(View view)
    {
        populate("3");
    }

    public void onClick04(View view)
    {
        populate("4");
    }

    public void onClick05(View view)
    {
        populate("5");
    }

    public void onClick06(View view)
    {
        populate("6");
    }

    public void onClick07(View view)
    {
        populate("7");
    }

    public void onClick08(View view)
    {
        populate("8");
    }

    public void onClick09(View view)
    {
        populate("9");
    }

    public void onClickDot(View view)
    {
        populate(".");
    }

    public void onClickAdd(View view)
    {
        updateValue();
        operator = '+';
        clear();
    }

    public void onClickSubtract(View view)
    {
        updateValue();
        operator = '-';
        clear();
    }

    public void onClickTimes(View view)
    {
        updateValue();
        operator = '*';
        clear();
    }

    public void onClickDivide(View view)
    {
        updateValue();
        operator = '/';
        clear();
    }

    public void onClickClear(View view)
    {
        clear();
        cValue = 0;
    }

    public void onClickEquals(View view)
    {
        updateValue();
        updateScreen();
        operator = 0;
    }

    public void clear()
    {
        resultEdit.setText("");

    }

    public void populate(String value)
    {
        String present = resultEdit.getText().toString();
        present+=value;
        resultEdit.setText(present);
    }

    private void updateValue()
    {
        double sValue = Double.valueOf(resultEdit.getText().toString());
        switch (operator)
        {
            case '+':
                cValue += sValue;
                break;
            case '-':
                cValue -= sValue;
                break;
            case '*':
                cValue *= sValue;
                break;
            case '/':
                cValue /= sValue;
                break;
            default:
                cValue = sValue;
                break;
        }
    }

    private void updateScreen()
    {
        resultEdit.setText(String.valueOf(cValue));
    }
}
