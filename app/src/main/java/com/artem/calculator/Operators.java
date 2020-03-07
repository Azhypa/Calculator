package com.artem.calculator;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

enum Operators{
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DEVIDE("/");

    private String code;

    Operators(String code){
        this.code = code;
    }
    public String getValue(){ return code;}

    public ArrayList<String> someMeth(){
        return new ArrayList<String>();
    }

    public HashSet<String> getAll(){
        return new HashSet<String>(){{
            add(PLUS.getValue());
            add(MINUS.getValue());
            add(MULTIPLY.getValue());
            add(DEVIDE.getValue());
        }};
    }

    public String calculate(double firstValue, double secondValue) {
        String answer = "";
        if (code.equalsIgnoreCase("+")){
            answer = String.valueOf(firstValue + secondValue);
        }
        if (code.equalsIgnoreCase("-")){
            answer = String.valueOf(firstValue - secondValue);
        }
        if (code.equalsIgnoreCase("*")){
            answer = String.valueOf(firstValue * secondValue);
        }
        if (code.equalsIgnoreCase("/")){
            answer = String.valueOf(firstValue / secondValue);
        }

        String checkIfFull = answer.substring(answer.indexOf(".") + 1);
        if (checkIfFull.length() == 1){
            if (Integer.parseInt(checkIfFull) == 0){
                answer = String.valueOf((int)(Double.parseDouble(answer)));
            }
        }

        return answer;
    }
}

