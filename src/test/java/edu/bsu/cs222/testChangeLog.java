package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;

public class testChangeLog extends ChangeLog{
    InputStream sampleTest = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
    DocumentContext sample = JsonPath.parse(sampleTest);
    @Test
    public void testChangeLogUser(){

        ArrayList<String> result = editor(sample);
        Assertions.assertEquals("Miklogfeather",result.get(0));

    }
    @Test
    public void testChangeLogTime(){
        ArrayList<String> result =time(sample);
        Assertions.assertEquals("2023-09-07T18:34:43Z", result.get(0));
    }

    @Test
    public void testChangeLogLength(){
        int result = countRevisions(sample);
        Assertions.assertEquals(4, result);
    }



}
