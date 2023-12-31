package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import java.util.ArrayList;
public class ChangeLogFormatter extends ChangeLog{
    public String changeLogToString (DocumentContext info){
        ArrayList<String> changeLog=timesAndUsers(info);
        return String.join("",changeLog);
    }
    public ArrayList<String> timesAndUsers (DocumentContext info){
        ArrayList<String> user = editor(info);
        ArrayList<String> time = time(info);
        ArrayList<String> changeLog = new ArrayList<>();
        for (int i = 0; i < user.size(); i++){
            changeLog.add("Date: "+ time.get(i) + "     |     User: " + user.get(i) + "\n");
        }
        return changeLog;
    }
    public String changeLogToStringHTML (DocumentContext info){
        ArrayList<String> changeLog=timesAndUsersHTML(info);
        return String.join("",changeLog);
    }
    public ArrayList<String> timesAndUsersHTML (DocumentContext info){
        ArrayList<String> user = editor(info);
        ArrayList<String> time = time(info);
        ArrayList<String> changeLog = new ArrayList<>();
        for (int i = 0; i < user.size(); i++){
            changeLog.add("Date: "+ time.get(i) + "     |     User: " + user.get(i) + "<br/>");
        }
        return changeLog;
    }
}



