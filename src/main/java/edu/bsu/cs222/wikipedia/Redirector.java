package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.swing.text.Document;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Redirector extends WikipediaConnection {

    public DocumentContext jsonInfo(){
        return JsonPath.parse(connectWikipedia());
    }
    //repeated code...... ^^ need to fix

    public int redirectCount(DocumentContext info){
        JSONArray path = info.read("$..to");
        ArrayList<String> redirectList = new ArrayList<>();
        if (checkRedirect(info)){
            redirectList.add(path.get(0).toString());
            return redirectList.size();
        } else {
            return 0;
        }
    }
    public boolean checkRedirect(DocumentContext info){
        JSONArray path = info.read("$..to");
        if (path.size() == 0){
            return false;
        }else{
            return true;
        }
    }

}
