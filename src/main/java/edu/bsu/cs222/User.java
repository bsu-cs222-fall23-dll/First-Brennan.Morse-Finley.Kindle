package edu.bsu.cs222;

public class User {
    public String getSearch(String userInput){
        return blankCheck(userInput);
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
