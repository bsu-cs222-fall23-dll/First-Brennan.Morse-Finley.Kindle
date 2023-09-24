package edu.bsu.cs222.wikipedia;

import java.io.*;
import java.util.Scanner;

public class User {
    public String getSearch(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What wikipedia article are you searching for?");
        String input = keyboard.nextLine();
        blankCheck(input);
        return input;
    }
    private void blankCheck(String search){
        if (search.equals("")){
            throw new Error("No input!");
        } if (search.trim().equals("")){
            throw new Error("No input!");
        }
    }
}
