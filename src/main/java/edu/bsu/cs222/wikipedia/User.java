package edu.bsu.cs222.wikipedia;

import java.io.*;
public class User {
    public String getSearch(){
        Console cnsl = System.console();
        String search = cnsl.readLine("What wikipedia article are you searching for?");
        blankCheck(search);
        return search;
    }
    private void blankCheck(String search){
        if (search.equals("")){
            throw new Error("No input!");
        } if (search.trim().equals("")){
            throw new Error("No input!");
        }
    }
}
