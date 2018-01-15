package com.java.training;

import com.java.training.interfaces.Calculator;
import com.java.training.models.MathExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class FileExpressionSolver {

    @Autowired
    ExpressionLoader expressionLoader;
    @Autowired
    Calculator calculator;

    public void solveMathExpression(){
        List<MathExpression> mathExpressions = expressionLoader.loadExpressions("src/test/resources/testfile2.txt");
        try(FileWriter fileWriter = new FileWriter("file1.txt")) {
            for (MathExpression mathExpression : mathExpressions) {
                Integer result = calculator.calculate(mathExpression);
                fileWriter.write(mathExpression.toString() + "=" + result.toString() + "\n");
            }
        } catch (IOException e){

        }
    }
}
