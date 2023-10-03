package edu.bsu.cs222;

public class User {
    public String getSearch(String userInput){
        String errorCheck = blankCheck(userInput);
        return errorCheck;
    }
    private String blankCheck(String userInput){
        if (userInput.equals("")){
            throw new Error("No input!");
            return "No input!";
        } if (userInput.trim().equals("")){
            throw new Error("No input!");
            return "No input!";
        }
        return userInput;
    }
}
