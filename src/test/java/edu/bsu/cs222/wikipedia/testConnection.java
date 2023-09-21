package edu.bsu.cs222.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testConnection {
    @Test
    public void testCreateURL(){
        WikipediaConnection connection = new WikipediaConnection();
        String input = "Frank Zappa";
        String output = connection.makeURL(input);
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=27&redirects", output);
    }


}
