package com.java.training;

import com.java.training.interfaces.MathExpressionsFileReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FileReaderTest {

    @Autowired
    MathExpressionsFileReader fileReader;

    @Test
    public void testReadFile(){
        List<String> lines = fileReader.readFile("src/main/resources/testfile.txt");
        Assert.assertFalse("List of math expressions is empty", lines.isEmpty());
    }

}
