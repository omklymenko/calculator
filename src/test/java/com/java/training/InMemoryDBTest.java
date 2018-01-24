package com.java.training;

import com.java.training.models.MathExpression;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@Transactional
public class InMemoryDBTest {

    @Resource
    private MathExpressionRepository mathExpressionRepository;
    @Autowired
    ExpressionLoader expressionLoader;

    @Test
    public void testSaveGetMathExpression() {
        List<MathExpression> mathExpressions = expressionLoader.loadExpressions("src/test/resources/testfile.txt");
        Assert.assertFalse("List is empty", mathExpressions.isEmpty());
        MathExpression mathExpression = mathExpressions.get(0);
        mathExpressionRepository.save(mathExpression);

        MathExpression mathExpression2 = mathExpressionRepository.findAll().get(0);
        System.out.println(mathExpression2);
        Assert.assertEquals("The result is not as expected", mathExpression, mathExpression2);
    }
}
