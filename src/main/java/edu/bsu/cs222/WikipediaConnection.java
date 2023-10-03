package edu.bsu.cs222;

import javax.management.RuntimeMBeanException;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.io.InputStream;

public class WikipediaConnection extends User {
    public String makeURL(String search){
        String title = URLEncoder.encode(search, Charset.defaultCharset());
        return String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=27&redirects", title);
    }
    public InputStream connectWikipedia(String input) {
        String urlFormatted = makeURL(input);

        try{
            java.net.URL url = new java.net.URL(urlFormatted);
            URLConnection connect = url.openConnection();
            connect.setRequestProperty("User-Agent", "Project 1(dllargent@bsu.edu)");
            return connect.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}