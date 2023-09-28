package edu.bsu.cs222;

import javax.swing.*;

public class User {
    public String getSearch(){
        var input = javax.swing.JOptionPane.showInputDialog("What wikipedia article are you searching for?");
        blankCheck(input);
        return input;
    }
    private void blankCheck(String search){
        if (search.equals("")){
            JOptionPane.showMessageDialog(null, "No input! System shutting down!");
            throw new Error("No input!");
        } if (search.trim().equals("")){
            JOptionPane.showMessageDialog(null, "No input! System shutting down!");
            throw new Error("No input!");
        }
    }
}
