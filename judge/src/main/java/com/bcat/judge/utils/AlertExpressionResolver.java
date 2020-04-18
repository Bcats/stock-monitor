package com.bcat.judge.utils;

import java.math.BigDecimal;

public class AlertExpressionResolver {

    // expressionMin数据类似： 7 gt 6.0 and 7 lt 7.12
    public boolean isTriggerAlarm(String expression, String getValue){

        String expressionMin = expression.replaceAll(" ", "");
        if (expressionMin.contains("gt") && expressionMin.contains("lt") && expressionMin.contains("or")) {
            String setMinValue = expressionMin.substring(expressionMin.indexOf("lt") + 2);
            String setMaxValue = expressionMin.substring(expressionMin.indexOf("gt") + 2, expressionMin.indexOf("or"));
            if (new BigDecimal(getValue).compareTo(new BigDecimal(setMaxValue)) == 1){
                return true;
            }
            if (new BigDecimal(getValue).compareTo(new BigDecimal(setMinValue)) == -1){
                return true;
            }
        }else if (expressionMin.contains("gt") && expressionMin.contains("lt") && expressionMin.contains("and")) {
            String setMinValue = expressionMin.substring(expressionMin.indexOf("gt") + 2, expressionMin.indexOf("and"));
            String setMaxValue = expressionMin.substring(expressionMin.indexOf("lt") + 2);
            if (new BigDecimal(setMinValue).compareTo(new BigDecimal(getValue)) == -1){
                if (new BigDecimal(setMaxValue).compareTo(new BigDecimal(getValue)) == 1){
                    return true;
                }
            }
        }else if (expressionMin.contains("gt")){
            String setValue = expressionMin.substring(expressionMin.indexOf("gt") + 2);
            if (new BigDecimal(getValue).compareTo(new BigDecimal(setValue)) == 1){
                return true;
            }
        }else if (expressionMin.contains("lt")){
            String setValue = expressionMin.substring(expressionMin.indexOf("lt") + 2);
            if (new BigDecimal(getValue).compareTo(new BigDecimal(setValue)) == -1){
                return true;
            }
        }
        return false;
    }

}
