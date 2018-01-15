package com.java.training;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FileExpressionSolverTest {

    @Autowired
    FileExpressionSolver fileExpressionSolver;

    @Test
    public void testReadFile(){
        String path = "src/test/resources/testfile2.txt";
        fileExpressionSolver.solveMathExpression(path);
        String resultFileName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".")) + "_result";
        File file = new File(resultFileName);
        Assert.assertTrue("File does not exist", file.exists());
        Assert.assertTrue("File is empty", file.length() != 0);
    }
}
