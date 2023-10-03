package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
//import java.util.Map;
//import java.util.List;

public class ChangeLog extends WikipediaConnection {
    public DocumentContext jsonInfo(String input){
        return JsonPath.parse(connectWikipedia(input));
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
        return editor(info).size();
    }
}
