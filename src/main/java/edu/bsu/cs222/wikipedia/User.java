package edu.bsu.cs222.wikipedia;

import java.io.*;
import java.util.Scanner;

public class User {
    public String getSearch(){
        var input = javax.swing.JOptionPane.showInputDialog("What wikipedia article are you searching for?");
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
