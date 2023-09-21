package edu.bsu.cs222.wikipedia;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs222.wikipedia.WikipediaConnection;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void testCreateURL(){
        WikipediaConnection connection = new WikipediaConnection();
        String input = "Frank Zappa";
        String output = connection.makeURL();
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=27&redirects", output);
        //so the reason this doesnt work is because it runs a method from user that takes input from the console
        //I have to split up the makeURL method so it takes a variable from a different method
        // its just very confusing and ill do it in class because i need help
    }

    //god i need to make more tests , talk about this in class

}
