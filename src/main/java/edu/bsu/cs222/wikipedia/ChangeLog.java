package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class ChangeLog extends WikipediaConnection {
    public DocumentContext jsonInfo(){
        return JsonPath.parse(connectWikipedia());
    }

    public ArrayList<Edit> changeLog(DocumentContext info){
        List<Map<String, Object>> changeLog = info.read("$..revisions[*]");
        ArrayList<Edit> newChangeLog = new ArrayList<>();
        for (Map<String,Object>  specificEdit : changeLog){
            //ask for help thinking of a new variable name for specificEdit
            Edit edit =new Edit();
            edit.setTimeChanged((String) specificEdit.get("timestamp"));
            edit.setUser((String) specificEdit.get("user"));
        }
        return newChangeLog;
    }
    public ArrayList<String> editor(DocumentContext info){
        JSONArray editor =info.read("$..user");
        ArrayList<String> editorList = new ArrayList<>();
        for (int i = 0 ; i < editor.toArray().length && i < 13 ; i++){
            editorList.add(editor.get(i).toString());
        }
        return editorList;
    }
    public ArrayList<String> time(DocumentContext info){
        JSONArray timeChanged = info.read("$..timestamp");
        ArrayList<String> timeChangedList = new ArrayList<>();
        for (int i = 0 ; i < timeChanged.toArray().length && i < 13 ; i++){
            timeChangedList.add(timeChanged.get(i).toString());
        }
        return timeChangedList;
    }
    public int countRevisions (DocumentContext info){
        int revisions = editor(info).size();
        return revisions;
    }
}
