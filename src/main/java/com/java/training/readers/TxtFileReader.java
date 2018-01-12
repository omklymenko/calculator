package com.java.training.readers;

import com.java.training.exceptions.FileLoaderException;
import com.java.training.interfaces.MathExpressionsFileReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class TxtFileReader implements MathExpressionsFileReader {

    public List<String> readFile(String path) {

        List<String> lines = new ArrayList<>();

        File f = new File(path);

        try(BufferedReader b = new BufferedReader(new FileReader(f))) {

            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
                System.out.println(readLine);
            }

        } catch (Exception e){
            throw new FileLoaderException();
        }

        return lines;
    }
}
