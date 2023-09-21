package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class testChangeLogFormatter extends ChangeLogFormatter {
    InputStream sampleTest = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
    DocumentContext sample = JsonPath.parse(sampleTest);

    @Test
    public void testChangeLogFormatted(){
        String result = changeLogToString(sample);
        Assertions.assertEquals("Miklogfeather 2023-09-07T18:34:43Z\n" +
                "ModernDayTrilobite 2023-09-07T17:21:48Z\n" +
                "Freefry 2023-09-02T15:06:03Z\n" +
                "Freefry 2023-09-02T15:05:04Z\n", result);
    }
}
