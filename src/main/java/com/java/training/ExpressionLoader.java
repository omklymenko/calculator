package com.java.training;

import com.java.training.enums.OperationType;
import com.java.training.interfaces.MathExpressionsFileReader;
import com.java.training.models.MathExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExpressionLoader {

    @Autowired
    MathExpressionsFileReader reader;

    public List<MathExpression> loadExpressions(String path) {
        List<MathExpression> mathExpressions = new ArrayList<>();
        Pattern pattern = Pattern.compile("((\\d+)|([\\+\\-\\*/])(\\d+))");
        List<String> expressions = reader.readFile(path);
        for (String expression : expressions){
            Matcher m = pattern.matcher(expression);
            List<String> symbols = new ArrayList<>();
            MathExpression mathExpression = new MathExpression();
            if (expression.matches("((\\d+)([\\+\\-\\*/])(\\d+))")) {
                while (m.find()) {
                    symbols.add(m.group());
                    System.out.println(m.group());
                }
                mathExpression.setFirstParam(Integer.valueOf(symbols.get(0)));
                mathExpression.setSecondParam(Integer.valueOf(symbols.get(2)));
                mathExpression.setOperationType(OperationType.getOperationType(symbols.get(1)));
                }
            mathExpressions.add(mathExpression);
        }
        return mathExpressions;
    }
}
