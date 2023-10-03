package edu.bsu.cs222;

import javax.swing.*;

public class User {
    public String checkSearch(String userInput){
        return blankCheck(userInput);
    }
    public String getSearch(){
        var input = javax.swing.JOptionPane.showInputDialog("What wikipedia article are you searching for?");
        String check = blankCheck(input);
        if (check.equals("No input!")){
            JOptionPane.showMessageDialog(null, "No input! System shutting down!");
            throw new Error("No input!");
        }
        return input;
    }
    private String blankCheck(String userInput){
        if (userInput.equals("")){
            return "No input!";
        } if (userInput.trim().equals("")){
            return "No input!";
        }
        return userInput;
    }
}
