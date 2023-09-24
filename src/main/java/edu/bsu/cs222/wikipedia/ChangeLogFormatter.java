package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.DocumentContext;
import java.util.ArrayList;
import java.lang.reflect.Array;
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
            changeLog.add(user.get(i)+ " " + time.get(i) + "\n");
        }
        return changeLog;
    }
}



