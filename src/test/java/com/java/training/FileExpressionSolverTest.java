package com.java.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FileExpressionSolverTest {

    @Autowired
    FileExpressionSolver fileExpressionSolver;

    @Test
    public void testReadFile(){
        fileExpressionSolver.solveMathExpression();
    }
}
