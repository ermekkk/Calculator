package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultView; //Output field for result
    TextView operationView; //Output operation
    EditText firstNumber;  //Input first number
    EditText secondNumber; //Input second number
    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnAnswer;

    double num1;
    double num2;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.resultView);
        operationView = (TextView) findViewById(R.id.operand);
        firstNumber = (EditText) findViewById(R.id.editText1);
        secondNumber = (EditText) findViewById(R.id.editText2);

        btnAdd = (Button) findViewById(R.id.btnadd);
        btnSub = (Button) findViewById(R.id.btnsub);
        btnMult = (Button) findViewById(R.id.btnmultiply);
        btnDiv = (Button) findViewById(R.id.btndiv);
        btnAnswer = (Button) findViewById(R.id.answer);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        num1 = Double.parseDouble(firstNumber.getText().toString());
        num2 = Double.parseDouble(secondNumber.getText().toString());

        if(TextUtils.isEmpty(firstNumber.getText().toString()) ||
                TextUtils.isEmpty((secondNumber.getText().toString()))){
            resultView.setText("Заполните все поля!");
        }

        switch (v.getId()){
            case R.id.btnadd:
                operationView.setText("+");
                result = num1 + num2;
                break;
            case R.id.btnsub:
                operationView.setText("-");
                result = num1 - num2;
                break;
            case R.id.btnmultiply:
                operationView.setText("x");
                result = num1 * num2;
                break;
            case R.id.btndiv:
                operationView.setText("÷");
                if(num2 != 0)
                    result = num1 / num2;
                else
                    resultView.setText("Бесконечность");
                break;
            default:
                break;
        }

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText("" + result);
            }
        });
    }
}