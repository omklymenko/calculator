package com.java.training;

import com.java.training.models.MathExpression;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ExpressionLoaderTest {

    @Autowired
    ExpressionLoader expressionLoader;

    @Test
    public void testLoadExpression() {
        List<MathExpression> mathExpression = expressionLoader.loadExpressions("src/main/resources/testfile.txt");
        Assert.assertFalse("List is empty", mathExpression.isEmpty());
    }
}
