package com.java.training;

import com.java.training.enums.OperationType;
import com.java.training.interfaces.MathExpressionsFileReader;
import com.java.training.models.MathExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExpressionLoader {

    private static final String CHECK_PATTERN = "(?!=[+\\-*/])(-?)(\\d+)([+\\-*/])(?!=[+\\-*/])(-?)(\\d+)";
    private static final String PARSE_PATTERN = "(-?\\d+)([+\\-*/])(-?\\d+)";

    @Autowired
    private MathExpressionsFileReader reader;

    public List<MathExpression> loadExpressions(String path) {
        List<MathExpression> mathExpressions = new ArrayList<>();
        Pattern pattern = Pattern.compile(PARSE_PATTERN);
        List<String> lines = reader.readFile(path);
        List<String> expressions = new ArrayList<>();
        for(String line : lines){
            String editedLine = line.replaceAll("[A-Za-z]", " ").replaceAll(" +", " ");
            expressions.addAll(Arrays.asList(editedLine.split(" ")));
        }
        for (String expression : expressions){
            Matcher m = pattern.matcher(expression);
            MathExpression mathExpression = new MathExpression();
            if (expression.matches(CHECK_PATTERN)) {
                while (m.find()) {
                    mathExpression.setFirstParam(Integer.valueOf(m.group(1)));
                    mathExpression.setSecondParam(Integer.valueOf(m.group(3)));
                    mathExpression.setOperationType(OperationType.getOperationType(m.group(2)));
                    mathExpressions.add(mathExpression);
                }
            }
        }
        return mathExpressions;
    }
}
