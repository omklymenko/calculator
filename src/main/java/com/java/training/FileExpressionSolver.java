package com.java.training;

import com.java.training.exceptions.FileCreationException;
import com.java.training.interfaces.Calculator;
import com.java.training.models.MathExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.util.List;

@Component
public class FileExpressionSolver {

    @Autowired
    ExpressionLoader expressionLoader;
    @Autowired
    Calculator calculator;

    public void solveMathExpression(String path){
        List<MathExpression> mathExpressions = expressionLoader.loadExpressions(path);
        String resultFileName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".")) + "_result";
        try(FileWriter fileWriter = new FileWriter(resultFileName)) {
            for (MathExpression mathExpression : mathExpressions) {
                Integer result = calculator.calculate(mathExpression);
                fileWriter.write(mathExpression.toString() + "=" + result.toString() + "\n");
            }
        } catch (Exception e){
            throw new FileCreationException();
        }
    }
}
