package com.java.training;

import com.java.training.interfaces.MathExpressionsFileReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class FileReaderTest {

    @Autowired
    MathExpressionsFileReader fileReader;

    @Test
    public void testReadFile(){
        fileReader.readFile("C:\\Users\\elena\\workspace\\calculator\\src\\main\\resources\\testfile.txt");
    }
}
