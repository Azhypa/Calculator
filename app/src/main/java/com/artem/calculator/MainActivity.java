package com.artem.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private double firstValue;
    private double secondValue;
    private Operators selectedOperator;

    private TextView input;
    private TextView output;

    private List<Button> numbersButtons;

    private Button number_1_btn;
    private Button number_2_btn;
    private Button number_3_btn;
    private Button number_4_btn;
    private Button number_5_btn;
    private Button number_6_btn;
    private Button number_7_btn;
    private Button number_8_btn;
    private Button number_9_btn;
    private Button number_0_btn;

    private List<Button> operatorButtons;

    private final int remove_btn_id = R.id.btn_remove;
    private Button remove_btn;
    private final int devide_btn_id = R.id.btn_devide;
    private Button devide_btn;
    private final int multiply_btn_id = R.id.btn_multiply;
    private Button multiply_btn;
    private final int plus_btn_id = R.id.btn_plus;
    private Button plus_btn;
    private final int minus_btn_id = R.id.btn_minus;
    private Button minus_btn;
    private final int answer_btn_id = R.id.btn_answer;
    private Button answer_btn;
    private final int dot_btn_id = R.id.btn_dot;
    private Button dot_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews(){
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        number_1_btn = findViewById(R.id.btn_1);
        number_2_btn = findViewById(R.id.btn_2);
        number_3_btn = findViewById(R.id.btn_3);
        number_4_btn = findViewById(R.id.btn_4);
        number_5_btn = findViewById(R.id.btn_5);
        number_6_btn = findViewById(R.id.btn_6);
        number_7_btn = findViewById(R.id.btn_7);
        number_8_btn = findViewById(R.id.btn_8);
        number_9_btn = findViewById(R.id.btn_9);
        number_0_btn = findViewById(R.id.btn_0);

         numbersButtons = new ArrayList<Button>(){{
            add(number_1_btn);
            add(number_2_btn);
            add(number_3_btn);
            add(number_4_btn);
            add(number_5_btn);
            add(number_6_btn);
            add(number_7_btn);
            add(number_8_btn);
            add(number_9_btn);
            add(number_0_btn);
        }};

        remove_btn = findViewById(remove_btn_id);
        devide_btn = findViewById(devide_btn_id);
        multiply_btn = findViewById(multiply_btn_id);
        plus_btn = findViewById(plus_btn_id);
        minus_btn = findViewById(minus_btn_id);
        answer_btn = findViewById(answer_btn_id);
        dot_btn = findViewById(dot_btn_id);

        operatorButtons = new ArrayList<Button>(){{
            add(remove_btn);
            add(devide_btn);
            add(multiply_btn);
            add(plus_btn);
            add(minus_btn);
            add(answer_btn);
            add(dot_btn);
        }};

        initializeClickListeners();
    }

    private void initializeClickListeners(){
        for (Button button: numbersButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input.append(((Button)view).getText().toString());
                }
            });
        }

        for (Button button: operatorButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOperatorBtnClick(v);
                }
            });
        }
    }

    private void onOperatorBtnClick(View view) {
        switch (view.getId()){
            case remove_btn_id:
                clearScreen();
                break;
            case devide_btn_id:
                onMathOperatorClick(Operators.DEVIDE);
                break;
            case multiply_btn_id:
                onMathOperatorClick(Operators.MULTIPLY);
                break;
            case plus_btn_id:
                onMathOperatorClick(Operators.PLUS);
                break;
            case minus_btn_id:
                onMathOperatorClick(Operators.MINUS);
                break;
            case answer_btn_id:
                try {
                    onAnswerClick();
                }catch (Exception e){}
                break;
            case dot_btn_id:
                if (selectedOperator == null){
                    if (input.getText().toString().length() != 0){
                        firstValue = Double.parseDouble(input.getText().toString());
                    }

                    if (firstValue % 1 != 0){
                        if (String.valueOf(firstValue).contains(".")){
                            return;
                        }
                    }
                }else {
                    String secondValueAsString = input.getText()
                            .toString()
                            .substring(
                                    input
                                            .getText()
                                            .toString()
                                            .indexOf(selectedOperator.getValue()) + 1);
                    secondValue = Double.parseDouble(secondValueAsString.trim());

                    if (secondValue % 1 != 0){
                        if (String.valueOf(secondValue).contains(".")){
                            return;
                        }
                    }
                }

                if (input.getText().toString().endsWith(".")){
                    return;
                }
                input.append(".");
                break;

        }
    }

    private void onAnswerClick(){
        String secondValueAsString = input.getText()
                .toString()
                .substring(
                        input
                                .getText()
                                .toString()
                                .indexOf(selectedOperator.getValue()) + 1);
        secondValue = Double.parseDouble(secondValueAsString.trim());
        output.setText(selectedOperator.calculate(firstValue, secondValue));
    }

    private void onMathOperatorClick(Operators operator){
        if (selectedOperator != null){
            return;
        }
        firstValue = Double.parseDouble(input.getText().toString());
        input.append(operator.getValue());
        selectedOperator = operator;
    }

    private void clearScreen() {
        input.setText("");
        output.setText("");
        selectedOperator = null;
    }

}
